package v1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@MappedEntity("employee_salary123")
@Serdeable
@Entity
public class EmployeeSalary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Column(name = "base_amount")
	private BigDecimal baseAmount;
	@Column(name = "hra")
	private BigDecimal hra;
	@Column(name = "pf")
	private BigDecimal pf;
	@Column(name = "medical")
	private BigDecimal medical;
	@Column(name = "tax")
	private BigDecimal tax;
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	@OneToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonBackReference
	private EmployeeModel employee;

	public EmployeeSalary() {
	}

	public EmployeeSalary(BigDecimal baseAmount, BigDecimal hra, BigDecimal pf, BigDecimal medical, BigDecimal tax, BigDecimal totalAmount) {
		this.baseAmount = baseAmount;
		this.hra = hra;
		this.pf = pf;
		this.medical = medical;
		this.tax = tax;
		this.totalAmount = totalAmount;
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

	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	public BigDecimal getHra() {
		return hra;
	}

	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}

	public BigDecimal getPf() {
		return pf;
	}

	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}

	public BigDecimal getMedical() {
		return medical;
	}

	public void setMedical(BigDecimal medical) {
		this.medical = medical;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
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
		return "EmployeeSalary{" +
				"baseAmount=" + baseAmount +
				", hra=" + hra +
				", pf=" + pf +
				", medical=" + medical +
				", tax=" + tax +
				", totalAmount=" + totalAmount +
				", employee=" + employee +
				", id=" + id +
				'}';
	}
}