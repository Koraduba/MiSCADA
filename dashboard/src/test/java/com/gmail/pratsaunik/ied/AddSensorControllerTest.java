package com.gmail.pratsaunik.ied;

import com.gmail.pratsaunik.WebAppTestConfiguration;
import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.SensorValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebAppTestConfiguration.class)
public class AddSensorControllerTest {

    static CurrentSensor createTestData(int i) {
      CurrentSensor currentSensor = new CurrentSensor();
      currentSensor.setSensorId(1L);
        return currentSensor;
    }

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addNewProduct() throws  Exception{
        String viewName;
        ModelAndView modelAndView = mockMvc.perform(get("/add/sensor")
                .param("deviceId", "1"))
                .andReturn()
                .getModelAndView();

        viewName = modelAndView.getViewName();
        Object item = modelAndView.getModel().get("deviceId");

        assertEquals("addSensorPage", viewName);
        assertEquals(1L,item);
        assertNotNull(item);
    }
/*
    @Sql(value = "/test-addsensor.sql")
    @Test
    public void showAddSensorPage() throws Exception {
        String viewName;
        CurrentSensor currentSensor=createTestData(1);
        ModelAndView modelAndView = mockMvc.perform(post("/add/sensor")
                .requestAttr("item", currentSensor)
                .param("deviceId", "1"))
                .andReturn()
                .getModelAndView();

        viewName = modelAndView.getViewName();
        Object item = modelAndView.getModel().get("deviceId");

        assertEquals("redirect:/product/item/{deviceId}", viewName);
        assertEquals(1L,item);
        assertNotNull(item);
    }
    */
}
