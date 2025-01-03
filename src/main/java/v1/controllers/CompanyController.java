package v1.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/v1/company")
public class CompanyController {

	@Get("/{id}/details")
	public String getCompanyDetails(String id) {
		return "finding company details for " + id;
	}

}
