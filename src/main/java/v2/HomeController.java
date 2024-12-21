package v2;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HomeController {

	@Get("/health")
	public String health(){
		return "health is ok";
	}

}
