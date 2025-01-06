package v1.resourceHandlers;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import v1.models.CompanyModel;
import v1.repositorys.CompanyRepository;
import v1.resources.CompanyResponseResource;

import java.util.Optional;

@Singleton
public class CompanyResourceHandler {

	private final CompanyRepository repository;

	@Inject
	public CompanyResourceHandler(CompanyRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public CompanyResponseResource getCompanyDetails(Long id) {
		Optional<CompanyModel> companyModel = repository.findById(id);
		if (companyModel.isPresent()) {
			return new CompanyResponseResource(companyModel.get());
		}
		return null;
	}

}
