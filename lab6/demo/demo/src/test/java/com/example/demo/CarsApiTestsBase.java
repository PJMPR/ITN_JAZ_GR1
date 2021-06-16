package com.example.demo;

import com.example.demo.contract.CarDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public abstract class CarsApiTestsBase {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;
    BasicJsonTester json = new BasicJsonTester(getClass()) ;

    public void testPostMethod()throws Exception{

        CarDto carDto = new CarDto("BMW","GD1234",200,false,20000);

        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carDto)))
                .andExpect(status().is(204));

        mvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("BMW"))
                .andExpect(jsonPath("$.registrationNumber").value("GD1234"))
                .andExpect(jsonPath("$.milleage").value(200))
                .andExpect(jsonPath("$.hasAccidents").value(false))
                .andExpect(jsonPath("$.price").value(20000));

        CarDto carDto1 = new CarDto("BMW1","GD1234",200,false,20000);
        CarDto carDto2 = new CarDto("BMW2","GD1234",200,false,20000);
        CarDto carDto3 = new CarDto("BMW3","GD1234",200,false,20000);
        System.out.println(carDto);
        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carDto1)));


        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carDto2)));


        mvc.perform(post("/cars")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carDto3)));

        mvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/cars/40").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        mvc.perform(put("/cars/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carDto3)))
                .andExpect(status().isOk())
        ;

        mvc.perform(MockMvcRequestBuilders.get("/cars/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.model").value("BMW3"));

        mvc.perform(put("/cars/60")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(carDto3)))
                .andExpect(status().isNotFound());


        mvc.perform(delete("/cars/1")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/1")).andExpect(status().isNotFound());
        mvc.perform(delete("/cars/2")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/2")).andExpect(status().isNotFound());
        mvc.perform(delete("/cars/3")).andExpect(status().isNoContent());
        mvc.perform(delete("/cars/3")).andExpect(status().isNotFound());
    }
}