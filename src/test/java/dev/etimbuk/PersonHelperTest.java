package dev.etimbuk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etimbuk.models.Address;
import dev.etimbuk.models.Person;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static dev.etimbuk.models.Gender.FEMALE;
import static dev.etimbuk.utils.PersonHelper.convertToJson;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonHelperTest {
    @Test
    void givenPersonHasEmptyFirstName_thenJsonShouldNotHaveFirstNameProperty() throws JsonProcessingException {
        Person personWithEmptyFirstname = Person.builder()
            .firstName("")
            .lastName("Last name")
            .gender(FEMALE)
            .address(Address.builder()
                .addressLine1("Address Line 1")
                .addressLine2("Address Line 2")
                .postcode("The Post Code")
                .build())
            .build();

        String returnedJson = convertToJson(personWithEmptyFirstname).orElse("");

        assertThat(returnedJson).isNotEmpty();

        Map<String, Object> personMap = of(returnedJson);

        assertThat(personMap).doesNotContainKey("firstName");
    }

    @Test
    void givenPersonHasNullLastName_thenJsonShouldNotHaveLastNameProperty() throws JsonProcessingException {
        Person personWithEmptyLastname = Person.builder()
            .firstName("First name")
            .gender(FEMALE)
            .address(Address.builder()
                .addressLine1("Address Line 1")
                .addressLine2("Address Line 2")
                .postcode("The Post Code")
                .build())
            .build();

        String returnedJson = convertToJson(personWithEmptyLastname).orElse("");

        assertThat(returnedJson).isNotEmpty();

        Map<String, Object> personMap = of(returnedJson);

        assertThat(personMap).doesNotContainKey("lastname");
    }

    @Test
    void givenEmptyPerson_thenShouldHaveEmptyJson() throws JsonProcessingException {
        String returnedJson = convertToJson(Person.builder().build()).orElse("{}");

        assertThat(returnedJson).isNotEmpty();

        Map<String, Object> personMap = of(returnedJson);

        assertThat(personMap).isEmpty();
    }

    private Map<String, Object> of(final String json) throws JsonProcessingException {
        return new ObjectMapper().reader()
            .forType(new TypeReference<Map<String, Object>>() {})
            .readValue(json);
    }
}
