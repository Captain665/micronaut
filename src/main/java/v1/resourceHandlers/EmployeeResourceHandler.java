package v1.resourceHandlers;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import v1.models.CompanyModel;
import v1.models.EmployeeModel;
import v1.models.EmployeeSalary;
import v1.repositories.AssetRepository;
import v1.repositories.CompanyRepository;
import v1.repositories.EmployeeRepository;
import v1.resources.EmployeeBuilder;
import v1.resources.EmployeeResource;

import java.math.BigDecimal;
import java.util.Optional;

@Singleton
public class EmployeeResourceHandler {
	private final CompanyRepository companyRepository;
	private final EmployeeRepository repository;
	private final AssetRepository assetRepository;

	public EmployeeResourceHandler(CompanyRepository companyRepository, EmployeeRepository repository, AssetRepository assetRepository) {
		this.companyRepository = companyRepository;
		this.repository = repository;
		this.assetRepository = assetRepository;
	}

	public EmployeeResource saveEmployeeDetails(EmployeeResource resource) {

		Optional<CompanyModel> companyModel = companyRepository.findById(resource.companyId);
		if (companyModel.isPresent()) {
			EmployeeModel employeeModel = new EmployeeBuilder()
					.setFullName(resource.getFullName())
					.setMobile(resource.getMobile())
					.setEmailId(resource.getEmailId())
					.setGender(resource.getGender())
					.setJoiningDate(resource.getJoiningDate())
					.setResignDate(resource.getResignDate())
					.setRole(resource.getRole())
					.setLocation(resource.getLocation())
					.setCompany(companyModel.get())
					.setAssets(resource.getAssets())
					.setSalary(calculateEmployeeSalary(resource.getSalaryStructure()))
					.build();
			EmployeeModel employeeModel1 = repositoryConnectionForSaveData(employeeModel);
			return new EmployeeResource(employeeModel1);
		}
		return null;

	}

	private EmployeeSalary calculateEmployeeSalary(EmployeeSalary employeeSalary) {
		BigDecimal baseAmount = employeeSalary.getBaseAmount() != null ? employeeSalary.getBaseAmount() : BigDecimal.ZERO;
		BigDecimal hra = employeeSalary.getHra() != null ? employeeSalary.getHra() : BigDecimal.ZERO;
		BigDecimal pf = employeeSalary.getPf() != null ? employeeSalary.getPf() : BigDecimal.ZERO;
		BigDecimal medical = employeeSalary.getMedical() != null ? employeeSalary.getMedical() : BigDecimal.ZERO;
		BigDecimal tax = employeeSalary.getTax() != null ? employeeSalary.getTax() : BigDecimal.ZERO;
		BigDecimal totalAmount = baseAmount.add(hra).add(pf).add(medical).subtract(tax);
		employeeSalary.setTotalAmount(totalAmount);
		return employeeSalary;
	}

	@Transactional
	public EmployeeModel repositoryConnectionForSaveData(EmployeeModel model) {
		Optional<EmployeeModel> modelInDb = repository.findByMobile(model.getMobile());

		if (modelInDb.isPresent()) {
			if (modelInDb.get().getAsset() != null) {
				modelInDb.get().getAsset().forEach(assetRepository::delete);
			}
			model.setId(modelInDb.get().getId());
			model.getSalary().setId(modelInDb.get().getSalary().getId());
			model.getSalary().setEmployee(model);
			model.getAsset().forEach(assetModel -> assetModel.setEmployee(model));
			model.setActive(modelInDb.get().getActive());
			model.setNewUser(false);
			return repository.updateEmployeeDetails(model);
		}

		model.getSalary().setEmployee(model);
		model.getSalary().setEmployee(model);
		model.getAsset().forEach(assetModel -> assetModel.setEmployee(model));
		model.setNewUser(true);
		model.setActive(true);
		return repository.insertEmployeeInfo(model);
	}
}


