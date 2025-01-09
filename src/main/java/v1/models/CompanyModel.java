package v1.models;

import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.Column;


@MappedEntity("company_details")
public class CompanyModel extends BaseModel {
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "gst_number")
	private String gstNo;
	@Column(name = "category")
	private String category;


	public CompanyModel() {

	}

	public CompanyModel(String name, String address, String city, String state, String country, String gstNo, String category) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.gstNo = gstNo;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}