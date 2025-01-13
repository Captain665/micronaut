package v1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@MappedEntity("company_assets123")
@Serdeable
@Entity
public class AssetModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Long id;
	@Column(name = "created_at", updatable = false)
	public LocalDateTime createdAt;
	@Column(name = "created_by")
	public String createdBy;
	@Column(name = "updated_at")
	public LocalDateTime updatedAt;
	@Column(name = "updated_by")
	public String updatedBy;
	@Column(name = "type")
	private String type;
	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private String price;
	@ManyToOne(optional = false)
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonBackReference
	private EmployeeModel employee;

	public AssetModel() {
	}

	public AssetModel(String type, String name, String quantity, String description, String price, EmployeeModel employee) {
		this.type = type;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.employee = employee;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@PrePersist
	@PreUpdate
	public void setCreatedAt() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.createdBy = "Customer";
		this.updatedBy = "Customer";
	}


	@Override
	public String toString() {
		return "AssetModel{" +
				"type='" + type + '\'' +
				", name='" + name + '\'' +
				", quantity='" + quantity + '\'' +
				", description='" + description + '\'' +
				", price='" + price + '\'' +
				", employee=" + employee +
				", id=" + id +
				'}';
	}
}