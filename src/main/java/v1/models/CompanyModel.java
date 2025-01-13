package v1.models;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@MappedEntity("company_details123")
@Serdeable
@Entity
public class CompanyModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public Long id;
	@Column(name = "created_at")
	public LocalDateTime createdAt;
	@Column(name = "created_by")
	public String createdBy;
	@Column(name = "updated_at")
	public LocalDateTime updatedAt;
	@Column(name = "updated_by")
	public String updatedBy;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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


	@PrePersist
	@PreUpdate
	public void setCreatedAt() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.createdBy = "Customer";
		this.updatedBy = "Customer";
	}

}