package com.alx.chitter.chitterBackend;

import com.alx.chitter.chitterBackend.model.Peeps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.alx.chitter.chitterBackend.helpers.JsonParser.jsonFileToObject;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class ChitterBackendApplicationTests {


	private List<Peeps> peeps = jsonFileToObject();
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void clearTestCollection(){
		TestMongoConfig.clearTestCollection();
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

	}

}
