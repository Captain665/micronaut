package v1.models;

import com.example.commons.enums.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.util.List;

@Serdeable
@MappedEntity("employee_details")
public class EmployeeModel extends BaseModel {
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "gender")
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	@Column(name = "joining_date")
	private String joiningDate;
	@Column(name = "resign_date")
	private String resignDate;
	@Column(name = "role")
	private String role;
	@Column(name = "location")
	private String location;
	@ManyToOne(targetEntity = CompanyModel.class, fetch = FetchType.EAGER, optional = false)
	private CompanyModel company;
	@OneToMany(targetEntity = AssetModel.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee", orphanRemoval = true)
	@JsonManagedReference
	private List<AssetModel> asset;
	@OneToOne(targetEntity = EmployeeSalary.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee", orphanRemoval = true)
	@JsonManagedReference
	private EmployeeSalary salary;
	@Column(name = "active")
	private Boolean active;
	@Column(name = "new_user")
	private Boolean newUser;

	public EmployeeModel() {
	}

	public EmployeeModel(String fullName, String mobile, String emailId, Gender gender, String joiningDate, String resignDate, String role, String location, CompanyModel company, List<AssetModel> asset, EmployeeSalary salary) {
		this.fullName = fullName;
		this.mobile = mobile;
		this.emailId = emailId;
		this.gender = gender;
		this.joiningDate = joiningDate;
		this.resignDate = resignDate;
		this.role = role;
		this.location = location;
		this.company = company;
		this.asset = asset;
		this.salary = salary;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getResignDate() {
		return resignDate;
	}

	public void setResignDate(String resignDate) {
		this.resignDate = resignDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CompanyModel getCompany() {
		return company;
	}

	public void setCompany(CompanyModel company) {
		this.company = company;
	}

	public List<AssetModel> getAsset() {
		return asset;
	}

	public void setAsset(List<AssetModel> asset) {
		this.asset = asset;
	}

	public EmployeeSalary getSalary() {
		return salary;
	}

	public void setSalary(EmployeeSalary salary) {
		this.salary = salary;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getNewUser() {
		return newUser;
	}

	public void setNewUser(Boolean newUser) {
		this.newUser = newUser;
	}

	@Override
	public String toString() {
		return "EmployeeModel{" +
				"fullName='" + fullName + '\'' +
				", mobile='" + mobile + '\'' +
				", emailId='" + emailId + '\'' +
				", gender=" + gender +
				", joiningDate='" + joiningDate + '\'' +
				", resignDate='" + resignDate + '\'' +
				", role='" + role + '\'' +
				", location='" + location + '\'' +
//				", asset=" + asset +
//				", salary=" + salary +
				", active=" + active +
				", newUser=" + newUser +
				", id=" + id +
				'}';
	}
}