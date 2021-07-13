package com.javaeethirdbatch.controller.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.hamcrest.collection.IsArray;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaeethirdbatch.dto.MovieDto;
import com.javaeethirdbatch.model.Genres;
import com.javaeethirdbatch.service.MovieService;

import static org.hamcrest.CoreMatchers.*;

@WebMvcTest(MovieRestController.class)
public class MovieRestControllerTest {
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    MovieService movieService;
    
    MovieDto m1 = new MovieDto(1L,"Movie 1","Dir 1",Genres.Action,1995L);
    MovieDto m2 = new MovieDto(2L,"Movie 2","Dir 1",Genres.Horror,1995L);
    MovieDto m3 = new MovieDto(3L,"Movie 3","Dir 1",Genres.Romance,1995L);
    
    @Test
    public void testGetAllMovie() throws Exception
    {
    	List<MovieDto> records = new ArrayList<>();
    	records.add(m1);
    	records.add(m2);
    	records.add(m3);
    	
    	Mockito.when(movieService.getAllMovie()).thenReturn(records);
    	
    	List<MovieDto> result = this.movieService.getAllMovie();
    	for(MovieDto dto: result)
    	{
    		System.out.println(dto);
    	}
    	mockMvc.perform(MockMvcRequestBuilders
                .get("/api/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("Movie 1")));
    }
    
    @Test
    public void testGetMovieById() throws Exception
    {   	
    	Mockito.when(movieService.getMovieById(1L)).thenReturn(m1);
    	mockMvc.perform(MockMvcRequestBuilders
                .get("/api/movies/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               // .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.name", is("Movie 1")));
    	
    	MovieDto emptyDto = new MovieDto();
    	Mockito.when(movieService.getMovieById(2L)).thenReturn(emptyDto);
    	mockMvc.perform(MockMvcRequestBuilders
                .get("/api/movies/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
               
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testPostSaveMovie()throws Exception
    {
    
    	Mockito.when(movieService.saveMovie(m1)).thenReturn(m1);
    	mockMvc.perform(MockMvcRequestBuilders
                .post("/api/movies")
                .content(asJsonString(m1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
               // .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$.name", is("Movie 1")));
    	
    	MovieDto invalidDto= new MovieDto();
    	mockMvc.perform(MockMvcRequestBuilders
                .post("/api/movies")
                .content(asJsonString(invalidDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
               
              
    	    
    }
    
}
