package com.renny.joblogger.controller;

import com.renny.joblogger.api.JobLoggerService;
import com.renny.joblogger.dto.LogMessageDTO;
import com.renny.joblogger.model.LogLevel;
import net.minidev.json.JSONValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {JobLogWriter.class})
public class JobLogWriterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobLoggerService service;

    @Test
    public void writeLogShouldBeOk() throws Exception {
        LogMessageDTO dto = new LogMessageDTO("HELLO WORLD!", LogLevel.ERROR);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/log")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSONValue.toJSONString(dto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}