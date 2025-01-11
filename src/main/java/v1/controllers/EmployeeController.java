package v1.controllers;

import com.example.commons.response.ApiResponse;
import com.example.commons.response.ApiSuccess;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import v1.resources.EmployeeResource;

@Controller("/v1/employee")
public class EmployeeController {

	private final Logger logger = LoggerFactory.getLogger("v1.employeeController");

	@Post
	public HttpResponse<ApiResponse> saveUpdate(@Body EmployeeResource resource) {
		logger.info("requested body " + resource);
		return HttpResponse.ok(new ApiSuccess("test passed"));
	}
}
