package com.example.evaaamo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class JsonService {

    public Map<String, String> readJsonFile(String path)  {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(
                    getClass().getClassLoader().getResourceAsStream(path), Map.class);
        }
        catch (IOException e) {
            return Map.of("Description", "File not found");
        }
    }
}
