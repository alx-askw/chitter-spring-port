package com.alx.chitter.chitterBackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ChitterBackendApplicationTests {

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
	}


}
