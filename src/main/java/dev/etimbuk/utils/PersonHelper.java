package dev.etimbuk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etimbuk.models.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

@Slf4j
public class PersonHelper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private PersonHelper() {
        objectMapper.configure(INDENT_OUTPUT, true);
    }

    public static Optional<String> convertToJson(final Person person) {
        try {
            return Optional.of(objectMapper.writeValueAsString(person));

        } catch (JsonProcessingException exc) {
            log.error("An error occurred during serialization ", exc);
        }

        return Optional.empty();
    }
}
