package dev.etimbuk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String postcode;
}
