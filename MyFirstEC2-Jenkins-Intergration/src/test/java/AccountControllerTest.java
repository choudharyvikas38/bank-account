import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.vc.config.StartApplication;
import org.vc.controller.AccountController;


/**
 * 
 * @author Vikas Choudhary
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class, secure=false)
@ContextConfiguration(classes={StartApplication.class})
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;
	

@Test
public void createAccount() throws Exception{
	/*Account account = Mockito.mock(Account.class);
	account.setAmount(2000);
	account.setNumber(11);
	
	String inputJSON = mapToJSON(account);*/
	String inputJSON = "{\"amount\":2000,\"number\":11}";
	String URI = "/api/account";
	RequestBuilder rBuilder = MockMvcRequestBuilders.post(URI).
			accept(MediaType.APPLICATION_JSON).content(inputJSON)
			.contentType(MediaType.APPLICATION_JSON);
	MvcResult mResult = mockMvc.perform(rBuilder).andReturn();
	MockHttpServletResponse response = mResult.getResponse();
	//System.out.println(mResult);
	String outputJSON = response.getContentAsString();
	System.out.println("output :: "+outputJSON);
	System.out.println(response.getStatus());
	System.out.println("input :: "+inputJSON);
	//assertThat(outputJSON, either(inputJSON));
	//assertTrue(outputJSON.equals(inputJSON));
	JSONAssert.assertEquals(outputJSON, inputJSON, false);
	assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	
}
@Test
public void getAmount() throws Exception{
	createAccount();
	String URI = "/api/account/11";
	
	RequestBuilder rBuilder  = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON);
	MvcResult mResult = mockMvc.perform(rBuilder).andReturn();
	MockHttpServletResponse response = mResult.getResponse();
	String outJSON = response.getContentAsString();
	System.out.println(outJSON);
	assertEquals(HttpStatus.OK.value(), response.getStatus());
	
}
/*
@Test(expected = Exception.class)
public void getAmountExceptionCheck() throws Exception{
	//createAccount();
	String URI = "/api/account/112";
	
	RequestBuilder rBuilder  = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)
			.contentType(MediaType.APPLICATION_JSON);
	MvcResult mResult = mockMvc.perform(rBuilder).andReturn();
	MockHttpServletResponse response = mResult.getResponse();
	String outJSON = response.getContentAsString();
	System.out.println(outJSON);
	//assertEquals(HttpStatus.OK.value(), response.getStatus());
	
}*/
/*private String mapToJSON(Object obj){
	ObjectMapper mapper = new ObjectMapper();
	return mapper.writeValueAsString(obj);
}*/
}