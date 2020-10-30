# Hibernate

##### Chapter 1(Introduction)

- Object-Relational mapping tool 
- implements JPA(Java persistence API)
- Refer sample hibernate.cfg.xml and POM file

##### Chapter 2 (Tables, Annotations,sessions and transaction)
- Every table should have a primary key
- Annotations

```

@Entity(name="EMP_DATA")
@Entiry
@Table(name="EMP_DATA")
@Id
@Coulumns
@Temporal(TemporalType.DATE) 
private Date empDoj;
@Transient
@Lob

```
	
- Creating Sessions and managing transaction

```
SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();  
Session session=sessionFactory.openSession();
session.beginTransaction();
........
........
session.getTransaction().commit();
session.close();
	
```

##### Chapter 3 (ID Generation)

```
Employee employee =session.get(Employee.class,1001);
```
- Id Generation

```
@Id
@GeneratedValue(strategy= GenerationType.AUTO/IDENTITY/SEQUENCE/TABLE
```
- Embedded Objects

```
@Embeddable
public class Address {
........


@Embedded
@AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "EMP_ADDRESS")),
			@AttributeOverride(name = "postCode", column = @Column(name = "EMP_POSTCODE")),
			@AttributeOverride(name = "city", column = @Column(name = "EMP_CITY")),
			@AttributeOverride(name = "country", column = @Column(name = "EMP_COUNTRY")) })
private Address empAddress;
```

- Composite Primary Key

```
@Embeddable
public class EmployeeId implements Serializable{
	private int id;
	private String department;
	........
	........

public class Employee implements Serializable{
	@Id
	@Embedded
	private EmployeeId empId;
```

##### Chapter 4(Persisting Collection of Objects)

```
@Embeddable
public class Address {
........
........

@Entity(name = "EMP_TABLE")
public class Employee implements Serializable{
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue
	private int empId;

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="EMP_ADDRESS")
	@JoinColumns(value = @JoinColumn(name="EMP_ID"))
	@GenericGenerator(name="mygenerator", strategy="increment")  
	@CollectionId(columns=@Column(name="ADDRESS_ID"), generator="mygenerator", type = @Type(type="long"))
	private Collection<Address> listOfAddress;

```

- Fetch= FetchType.EAGER/LAZY

##### Chapter 5 (Mapping)

```
1. OneToOne Unidirectional
-------------------------
Employee.java
    @OneToOne
	@JoinColumn(name="Address_id")
	private  Address address;
	
2. OneToOne bidirectional
-------------------------
Address.java
	@OneToOne
	@JoinColumn(name="employee_id")
	private Employee employee;


3. OneToMany and ManyToOne
--------------------------

Employee.java
	@OneToMany(mappedBy="employee")  
	private Collection<Flat> flatCollection;

Address.java
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee employee;

4. ManyToMany
-------------

Employee.java
	@ManyToMany(mappedBy="employeeCollection",cascade=CascadeType.PERSIST)
	private  Collection<Address> listOfAddress;
	.......

Address.java	
	@ManyToMany
	@JoinTable(name="address_employee"
	,joinColumns=@JoinColumn(name="address_id")
	,inverseJoinColumns=@JoinColumn(name="employee_id") )
	Collection<Employee> employeeCollection;	
```
- Cascade property

```
	@OneToMany(mappedBy="employeeCollection",cascade=CascadeType.PERSIST)
	private  Collection<Address> listOfAddress;
	
	session.persist(employee1); // Persist employee and related objects
```

##### Chapter 6(Inheritance)

```
@Entity(name = "Employee")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE/TABLE_PER_CLASS/JOINED)

// In case of InheritanceType.SINGLE_TABLE

System will create a discriminating column DTYPE of type varchar(31)

else we can define our own discriminating column as

@DiscriminatorColumn(name="empType")
@DiscriminatorValue("e")

ContractEmployee.java
@Entity
@DiscriminatorColumn(name="empType")
@DiscriminatorValue("ce")
public class ContractEmployee extends Employee

// In case of InheritanceTypeTABLE_PER_CLASS/JOINED
@Entity
@PrimaryKeyJoinColumn(name="empId")
public class ContractEmployee extends Employee

```

##### Chapter 7(Object Status)
- Persistent, Transient and detached
- Transient -> Created with new but not associated with a session
- Detached -> Object fetched and session is closed
- Persistent -> Object saved and session is still active
- In case of persistent state,any change will be detected by hibernate and synchorinized when transaction complete
- CRUD Operations
-	save, update,delete

##### Chapter 8(HQL)

```
1. Querying a table
-------------------
		Query query = session.createQuery("from Employee");
		
		List<Employee> empList = query.list();
		
		Iterator<Employee> iter = empList.iterator();
		
		System.out.println("Id\t"+"Name\t"+"Address");
		
		while(iter.hasNext()) {
			Employee emp = iter.next();
			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAddress());
		}

2. Selecting multiple columns
-----------------------------
		Query query = session.createQuery("select empName,empAddress from Employee");
		
		List<Object[]> empList = query.list();
		
		Iterator<Object[]> iter = empList.iterator();
		
		System.out.println("Name\t"+"Address");
		
		while(iter.hasNext()) {
			Object[] emp = iter.next();
			System.out.println(emp[0]+"\t"+emp[1]);
		}

3. Order By
-----------
		Query query = session.createQuery("from Employee order by empName");
		
4. Group by
----------
		Query query = session.createQuery("select empType,avg(salary) from Employee group by empType");
		
		List<Object[]> empList = query.list();
		
		Iterator<Object[]> iter = empList.iterator();
		
		System.out.println("Type\t"+"Average");
		
		while(iter.hasNext()) {
			Object[] emp = iter.next();
			System.out.println(emp[0]+"\t"+emp[1]);
		}

5. Aggregate Functions
----------------------
		Query query = session.createQuery("select count(salary),min(salary),max(salary),avg(salary),sum(salary) from Employee");
		
		List<Object[]> empList = query.list();
		
		Iterator<Object[]> iter = empList.iterator();
		
		System.out.println("Salary details");
		
		while(iter.hasNext()) {
			Object[] emp = iter.next();
			System.out.println("Count: "+emp[0]);
			System.out.println("Min: "+emp[1]);
			System.out.println("Max: "+emp[2]);
			System.out.println("Avg: "+emp[3]);
			System.out.println("Sum: "+emp[4]);
		}

6. Pagination
--------------
		Query query = session.createQuery("from Employee order by empName");
		query.setFirstResult(1);
		query.setMaxResults(2);
		
		List<Employee> empList = query.list();
		
		Iterator<Employee> iter = empList.iterator();
		
		System.out.println("Id\t"+"Name\t"+"Address");
		
		while(iter.hasNext()) {
			Employee emp = iter.next();
			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAddress());
		}

```

##### Chapter 9( Query Parameters, Named queries)	

- Positional parameters	

```
String queryString = "select userId from my_users where userName=?0 and password=?1";
			
		
		Query query = session.createQuery(queryString);
		
		query.setParameter(0, "Amit");
		query.setParameter(1, "123");

```

- Named parameters

```
		String queryString = "select userId from my_users where userName=:userName and password=:password";
			
		
		Query query = session.createQuery(queryString);
		
		query.setParameter("userName", "Amit");
		query.setParameter("password", "123");

```

- Named Query

```
@Entity(name = "Employee")
@NamedQueries({
@NamedQuery(name="findByName",query="from Employee where empName=:empName"),
@NamedQuery(name="MoreThanSalary",query="from Employee where salary>:salary")
})
public class Employee{
...........
...........

		Query query = session.getNamedQuery("findByName");
		
		query.setParameter("empName", "Amit");

		List<Employee> list = query.list();


```