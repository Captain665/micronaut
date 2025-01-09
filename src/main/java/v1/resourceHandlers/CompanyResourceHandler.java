package v1.resourceHandlers;

import jakarta.inject.Singleton;
import v1.repositories.CompanyRepository;
import v1.resources.CompanyResponseResource;

import java.util.Optional;

@Singleton
public class CompanyResourceHandler {

	private final CompanyRepository repository;

	public CompanyResourceHandler(CompanyRepository repository) {
		this.repository = repository;
	}

	public Optional<CompanyResponseResource> getCompanyDetails(Long id) {
		return repository.findById(id).map(CompanyResponseResource::new);
	}

}
