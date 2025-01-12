package v1.controllers;

import com.example.commons.response.ApiFailure;
import com.example.commons.response.ApiResponse;
import com.example.commons.response.ApiSuccess;
import com.example.commons.response.ErrorCode;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import v1.resourceHandlers.EmployeeResourceHandler;
import v1.resources.EmployeeResource;

@Controller("/v1/employee")
public class EmployeeController {
	private final EmployeeResourceHandler resourceHandler;

	private final Logger logger = LoggerFactory.getLogger("v1.employeeController");

	public EmployeeController(EmployeeResourceHandler resourceHandler) {
		this.resourceHandler = resourceHandler;
	}

	@Post
	public HttpResponse<ApiResponse> saveUpdate(@Body EmployeeResource resource) {
		logger.info("requested body " + resource);
		EmployeeResource responseResource = resourceHandler.saveEmployeeDetails(resource);
		if (responseResource != null) {
			return HttpResponse.ok(new ApiSuccess(responseResource));
		}
		return HttpResponse.badRequest(
				new ApiFailure("Company id not found",
						new ErrorCode("6", "COMPANY_ID", "Company id not found")));

	}
}
