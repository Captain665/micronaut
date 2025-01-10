package v1.resourceHandlers;

import jakarta.inject.Singleton;
import v1.models.EmployeeModel;
import v1.repositories.CompanyRepository;
import v1.repositories.EmployeeRepository;
import v1.resources.CompanyResponseResource;
import v1.resources.EmployeeResponseResource;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Singleton
public class CompanyResourceHandler {

	private final CompanyRepository repository;
	private final EmployeeRepository employeeRepository;

	public CompanyResourceHandler(CompanyRepository repository, EmployeeRepository employeeRepository) {
		this.repository = repository;
		this.employeeRepository = employeeRepository;
	}

	public Optional<CompanyResponseResource> getCompanyDetails(Long id) {
		Optional<CompanyResponseResource> responseResource = repository.findById(id).map(CompanyResponseResource::new);
		if (responseResource.isPresent()) {
			List<EmployeeResponseResource> employeeResponse = getEmployeeDetails(id).stream().map(EmployeeResponseResource::new).toList();
			responseResource.get().setNumberOfEmployee(BigInteger.valueOf(employeeResponse.size()));
			responseResource.get().setEmployeeDetails(employeeResponse);
			return responseResource;
		}
		return Optional.empty();
	}


	public List<EmployeeModel> getEmployeeDetails(Long companyId) {
		return employeeRepository.findByCompanyId(companyId).stream().filter(EmployeeModel::getActive).toList();

	}


}
