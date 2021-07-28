package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.service.AppleService;
import com.example.demo.mapping.ApiMapping;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Rajkumar Banala 11-Mar-2021
 *
 */

@WebMvcTest(AppleController.class)
class AppleControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AppleService appleService;
	
	public static final String API = ApiMapping.AppleControllerMapping.API;
	
	@Test
	void create() {
		
		try {
			
			// given
			Map<String, Object> requestData = new HashMap<>();
			String jsonString = new ObjectMapper().writeValueAsString(requestData);
			
			// when
			Map<String, Object> mockData = new HashMap<>();
			mockData.put("name", "James");
			when(appleService.create(Mockito.any())).thenReturn(mockData);
			
			// test
			String url = API;
			
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders
					.post(url)
					.contentType(MediaType.APPLICATION_JSON.toString())
					.content(jsonString))
					.andExpect(status().isOk())
					.andReturn();
			
			assertThat(result).isNotNull();
			MockHttpServletResponse mockHttpServletResponse = result.getResponse();
			assertThat(mockHttpServletResponse).isNotNull();
			assertThat(mockHttpServletResponse.getContentAsString()).isNotNull();
			
			// expect
			TypeReference<Map<String, Object>> typeReferenceMap = new TypeReference<Map<String,Object>>() {
			};
			Map<String, Object> responseMap = new ObjectMapper().readValue(mockHttpServletResponse.getContentAsString(), typeReferenceMap); 
			assertThat(responseMap).isNotNull();
			assertEquals("James", responseMap.get("name"));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	@Test
	void get() {
		
		try {
			
			// given
			
			// when
			when(appleService.get(Mockito.any())).thenReturn("a");
			
			// test
			String url = API + "/" + 1;
			
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders
					.get(url))
					.andExpect(status().isOk())
					.andReturn();

			assertThat(result).isNotNull();
			MockHttpServletResponse mockHttpServletResponse = result.getResponse();
			assertThat(mockHttpServletResponse).isNotNull();
			assertThat(mockHttpServletResponse.getContentAsString()).isNotNull();
			
			// expect
			String response = mockHttpServletResponse.getContentAsString();
			assertThat(response).isNotNull();
			assertEquals("a", response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
