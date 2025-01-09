package v1.controllers;

import com.example.commons.response.ApiFailure;
import com.example.commons.response.ApiResponse;
import com.example.commons.response.ApiSuccess;
import com.example.commons.response.ErrorCode;
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

	public CompanyController(CompanyResourceHandler resourceHandler) {
		this.resourceHandler = resourceHandler;
	}

	@Get("/{id}/details")
	public HttpResponse<ApiResponse> getCompanyDetails(Long id) {
		System.out.println("resource id " + resourceHandler.getCompanyDetails(id));
		Optional<CompanyResponseResource> responseResource = resourceHandler.getCompanyDetails(id);
		if (responseResource.isPresent()) {
			return HttpResponse.ok(new ApiSuccess(responseResource.get()));
		}
		return HttpResponse.badRequest(new ApiFailure("Company id not found", new ErrorCode("6", "COMPANY_ID", "Company id not found")));
	}

}
