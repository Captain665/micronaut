package v1.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import v1.resourceHandlers.CompanyResourceHandler;
import v1.resources.CompanyResponseResource;

import java.util.Optional;

@Controller("/v1/company")
public class CompanyController {
	private final CompanyResourceHandler resourceHandler;

	@Inject
	public CompanyController(CompanyResourceHandler resourceHandler) {
		this.resourceHandler = resourceHandler;
	}

	@Get("/{id}/details")
	public HttpResponse<String> getCompanyDetails(Long id) {
		System.out.println("resource id " + resourceHandler.getCompanyDetails(id));
		CompanyResponseResource responseResource = resourceHandler.getCompanyDetails(id);
		if (responseResource == null) {
			return HttpResponse.ok("id not present");
		}
		return HttpResponse.notFound("data found");
	}

}
