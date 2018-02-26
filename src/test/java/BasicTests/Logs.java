package BasicTests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Logs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Base URL or Host
		
		RestAssured.baseURI="https://maps.googleapis.com";
		given().
				param("location","-33.8670,151.1957").
				param("key","AIzaSyBKv86vxfkzsZ5njlHMjpG3sARGuvV_hEg").
				param("radius","500").
				param("type","restauran").
				param("keyword","cruise").log().all().
				when().
				get("/maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().
				//body("results[0].geometry.location.lat",equalTo("-33.86759"));
				body("results[0].name",equalTo("Magistic Cruises")).and().
				body("results[0].place_id",equalTo("ChIJxRjqYTiuEmsRGebAA_chDLE")).and().
				//test headers
				header("Server","scaffolding on HTTPServer2").log().body();
		
				
	}	
}
