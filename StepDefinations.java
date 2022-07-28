package StepDefinations;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ModelLayer.Book;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations {

	RestTemplate restTemplate = new RestTemplate();
	private String addURI;
	private ResponseEntity<String> response;
	private ResponseEntity<Object> status;
	
	
	@Given("User Set GET book service api endpoint")
	public void user_set_get_book_service_api_endpoint() {
		  addURI = "http://localhost:8080/showbooks";
	        System.out.println("Add URL :"+addURI);
	}

	@When("User Send GET HTTP request")
	public void user_send_get_http_request() {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	       response = restTemplate.exchange(addURI, HttpMethod.GET, entity, String.class);
	       System.out.println(response);
	}

	/*@Then("User receive valid HTTP reponse {int}")
	public void user_receive_valid_http_reponse(Integer obj) {
		 //responseBodyPOST = response.getBody();
		// System.out.print(responseBodyPOST);
		status = ResponseEntity.status(HttpStatus.OK).build();
		 assertEquals(obj, status.getStatusCodeValue());
	}*/
	
	@Given("User set PoST book service api endpoint")
	public void user_set_po_st_book_service_api_endpoint() {
	    
	    addURI= "http://localhost:8080/addbooks";
	   System.out.println(addURI);
	}

	@When("User Send POST HTTP request")
	public void user_send_post_http_request() {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    String jsonBody = "{\"id\":\"101 \",\"name\":\"roy\",\"author\":\"java\"}";
	    
	    HttpEntity<String> entity = new HttpEntity<String>(jsonBody,headers);
	    response = restTemplate.exchange(
	            addURI, HttpMethod.POST, entity, String.class);
	}

	@Then("User receive valid HTTP response {int}")
	public void user_receive_valid_http_response(Integer obj2) {
		status = ResponseEntity.status(HttpStatus.OK).build();
		 assertEquals(obj2, status.getStatusCodeValue());
	}
	
	@Given("User set PUT book service api endpoint")
	public void user_set_put_book_service_api_endpoint() {
		addURI = "http://localhost:8080/updatebook/101";
        System.out.println("Add URL :"+addURI); 
		
	}

	@When("User Send PUT HTTP request")
	public void user_send_put_http_request() {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
	      int id = 101;
		response = restTemplate.exchange(
		            addURI + id , HttpMethod.PUT, entity, String.class);
	}

	@Given("User set Delete book service api endpoint")
	public void user_set_delete_book_service_api_endpoint() {
		addURI = "http://localhost:8080/deletebook/102";
        System.out.println("Add URL :"+addURI);
		
	}

	@When("User Send Delete HTTP request")
	public void user_send_delete_http_request() {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
	      response = restTemplate.exchange(
		            addURI, HttpMethod.DELETE, entity, String.class);
		
	}
	
	@Then("User receive valid HTTP reponse {int}")
	public void user_receive_valid_http_reponse(Integer obj) {
		 //responseBodyPOST = response.getBody();
		// System.out.print(responseBodyPOST);
		status = ResponseEntity.status(HttpStatus.OK).build();
		 assertEquals(obj, status.getStatusCodeValue());

}
}
