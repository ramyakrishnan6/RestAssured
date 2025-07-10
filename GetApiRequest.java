package restful;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Comget {

	@Test
	public void GetApiRequest() {

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.asPrettyString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody());
		System.out.println(res.getTime());
		System.out.println(res.getHeader("Content-Type"));

		int actualcode = res.getStatusCode();

		int expectedcode = 200;
		Assert.assertEquals(expectedcode, actualcode);
	}
	@Test
	public void GetRequest2() {
		// given , when, then

		given()
			.baseUri("https://reqres.in")

		.when()
			.get("/api/users/2")
		.then()
			.statusCode(200);

	}

}
