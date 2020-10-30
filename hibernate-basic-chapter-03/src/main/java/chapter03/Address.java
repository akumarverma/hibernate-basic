package chapter03;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String address;
	private String postCode;
	private String city;
	private String country;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Address() {}

	public Address(String address, String postCode, String city, String country) {
		super();
		this.address = address;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", postCode=" + postCode + ", city=" + city + ", country=" + country
				+ "]";
	}
	
	
	

}
