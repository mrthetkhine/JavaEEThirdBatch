package com.javaeethirdbatch;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaeethirdbatch.controller.HomeController;
import com.javaeethirdbatch.service.MovieService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class SpringCourseApplicationTests {
	
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    
    @Autowired
    MovieService movieService;
   
	@Test
	void contextLoads() {
		System.out.println("Integration test loaded");
	}
	
	@Test
	public void testRestController() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders
                .get("/api/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("Titanic Test")))
                .andExpect(jsonPath("$[0].director", is("JameCameron")));
	}

}
