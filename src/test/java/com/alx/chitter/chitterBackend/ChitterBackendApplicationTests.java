package com.alx.chitter.chitterBackend;

import com.alx.chitter.chitterBackend.model.Peeps;
import com.alx.chitter.chitterBackend.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.alx.chitter.chitterBackend.helpers.JsonParser.jsonFileToObject;
import static com.alx.chitter.chitterBackend.helpers.JsonParser.userJsonFileToObject;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class ChitterBackendApplicationTests {


	private List<Peeps> peeps = jsonFileToObject();

	private List<User> users = userJsonFileToObject();
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void clearTestCollection(){
		TestMongoConfig.clearTestCollection();
	}

	@BeforeEach
	void clearUserTestCollection(){
		TestMongoConfig.clearUserTestCollection();
	}


	@Nested
	@DisplayName("GET PEEPS")
	class GetAll {

		@Test
		@DisplayName("request on get all peeps route - should return 200 ok")
		void shouldReturnHTTPResOf200() throws Exception {
			mockMvc.perform(get("/")).andExpect((status().isOk()));
		}

		@Nested
		@DisplayName("Checking JSON on Get")
		class GeTAllJSON {

			@BeforeEach
			void repopulateDB(){
				TestMongoConfig.populateTestCollection(peeps);
			}

			@Test
			@DisplayName("Should return list size of 3")
			void shouldReturnListLengthOf3() throws Exception{
				mockMvc.perform(get("/")).andExpect(jsonPath("$", hasSize(3)));
			}

		}

	}

	@Nested
	@DisplayName("Login Tests")
	class PostLogin {
		@BeforeEach
		void populateUserTestCollection(){
			TestMongoConfig.populateUserTestCollection(users);
		}

		//creating a json string in java
		//https://medium.com/@techisbeautiful/unit-testing-json-processing-in-java-a-practical-guide-to-ensure-your-code-is-bulletproof-f924694d3401

		@Test
		@DisplayName("Correct Login should return 200")
		void shouldReturn200OkOnCorrectLogin() throws Exception{
			String testJsonString = "{\"userEmail\": \"scrabb1001@email.com\", \"password\" : \"password2\"}";
			mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(testJsonString)).andExpect(status().isOk());
		}

		@Test
		@DisplayName("Should return 401 Unauthorised on incorrect details")
		void shouldReturn401UnauthWithIncorrectDeatails() throws Exception{
			String testJsonString = "{\"userEmail\": \"notarealemail@email.com\", \"password\" : \"fakepassword\"}";
			mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(testJsonString))
					.andExpect(status().is(401));
		}
		@Test
		@DisplayName("Should return 400 bad req with no post body")
		void shouldReturn400BadReqWithNoPostBody() throws Exception{
			mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().is(400));
		}

	}

}
