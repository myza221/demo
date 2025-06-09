package com.example.demo.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class BuddhistDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateStr = p.getText(); // e.g. "2567-06-09"
        LocalDate buddhistDate = LocalDate.parse(dateStr); // parse as-is
        return buddhistDate.minusYears(543); // convert to Gregorian
    }
}
