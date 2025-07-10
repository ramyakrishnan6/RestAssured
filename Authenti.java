package restful;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authenti {

	@Test
	public void basicAuthTest() {

		given().baseUri("https://postman-echo.com") // use https for postman-echo
				.basePath("/basic-auth").auth().preemptive().basic("postman", "0").when().get().then().statusCode(200)
				.body("authenticated", equalTo(true)).log().all();
	}

	@Test
	public void digestAuthTest() {

		given().baseUri("https://httpbin.org").basePath("/digest-auth/auth/prachi/prachi12").auth()
				.digest("Murali", "dharan").when().get().then().statusCode(200).body("authenticated", equalTo(true))
				.body("user", equalTo("Murali")).log().all();
	}
}
