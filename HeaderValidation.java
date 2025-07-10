package restful;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderValidation {

	@Test
	public void validateHeaderBDD() {

		// Step 1: Send GET request using BDD
		Response response = given().baseUri("https://reqres.in").when().get("/api/users/2").then().assertThat()
				.statusCode(200).header("Content-Type", equalTo("application/json; charset=utf-8")).extract()
				.response(); // extract response for further checks

		// Step 2: Print all headers (optional)
		Headers headersList = response.getHeaders();
		System.out.println("----- Response Headers -----");
		for (Header header : headersList) {
			System.out.println(header.getName() + ": " + header.getValue());
		}
	}
}
