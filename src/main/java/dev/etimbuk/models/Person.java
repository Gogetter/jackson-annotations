package dev.etimbuk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.etimbuk.models.Address;
import dev.etimbuk.models.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Person {
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private Address address;
}
