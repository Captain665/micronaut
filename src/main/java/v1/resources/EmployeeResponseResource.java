package v1.resources;

import com.example.commons.enums.Gender;
import io.micronaut.serde.annotation.Serdeable;
import v1.models.EmployeeModel;

import java.util.List;

@Serdeable
public class EmployeeResponseResource {
	public Long id;
	public String fullName;
	public String mobile;
	public String emailId;
	public Gender gender;
	public String joiningDate;
	public String resignDate;
	public String role;
	public String location;
	public List<AssetResource> assets;
	public EmployeeSalaryResource salaryStructure;

	public EmployeeResponseResource() {
	}

	public EmployeeResponseResource(EmployeeModel model) {
		this.id = model.getId();
		this.fullName = model.getFullName();
		this.mobile = model.getMobile();
		this.emailId = model.getEmailId();
		this.gender = model.getGender();
		this.joiningDate = model.getJoiningDate();
		this.resignDate = model.getResignDate();
		this.role = model.getRole();
		this.location = model.getLocation();
		this.assets = model.getAsset().stream().map(AssetResource::new).toList();
		this.salaryStructure = new EmployeeSalaryResource(model.getSalary());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<AssetResource> getAssets() {
		return assets;
	}

	public void setAssets(List<AssetResource> assets) {
		this.assets = assets;
	}

	public EmployeeSalaryResource getSalaryStructure() {
		return salaryStructure;
	}

	public void setSalaryStructure(EmployeeSalaryResource salaryStructure) {
		this.salaryStructure = salaryStructure;
	}

	@Override
	public String toString() {
		return "EmployeeResponseResource{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", mobile='" + mobile + '\'' +
				", emailId='" + emailId + '\'' +
				", gender=" + gender +
				", joiningDate='" + joiningDate + '\'' +
				", resignDate='" + resignDate + '\'' +
				", role='" + role + '\'' +
				", location='" + location + '\'' +
				", assets=" + assets +
				", salaryStructure=" + salaryStructure +
				'}';
	}
}
