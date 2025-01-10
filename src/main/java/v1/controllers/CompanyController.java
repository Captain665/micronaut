package v1.controllers;

import com.example.commons.response.ApiFailure;
import com.example.commons.response.ApiResponse;
import com.example.commons.response.ApiSuccess;
import com.example.commons.response.ErrorCode;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import v1.resourceHandlers.CompanyResourceHandler;
import v1.resources.CompanyResponseResource;

import java.util.Optional;

@Controller("/v1/company")
public class CompanyController {
	private final CompanyResourceHandler resourceHandler;
	private final Logger logger = LoggerFactory.getLogger("v1.CompanyController");

	public CompanyController(CompanyResourceHandler resourceHandler) {
		this.resourceHandler = resourceHandler;
	}

	@Get("/{id}/details")
	public HttpResponse<ApiResponse> getCompanyDetails(Long id) {
		logger.info("requested company id is : " + id);
		Optional<CompanyResponseResource> responseResource = resourceHandler.getCompanyDetails(id);
		if (responseResource.isPresent()) {
			logger.info(" response : " + responseResource.get());
			return HttpResponse.ok(new ApiSuccess(responseResource.get()));
		}
		logger.info("error : Company id not found");
		return HttpResponse.badRequest(
				new ApiFailure("Company id not found",
						new ErrorCode("6", "COMPANY_ID", "Company id not found")));
	}

}
