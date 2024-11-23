package com.aaradhya.acedmiaerpbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public record DomainResponse(
        @JsonProperty("id")
        int id,
        @JsonProperty("program")
        String program,
        @JsonProperty("email")
        String email,
        @JsonProperty("batch")
        int batch,
        @JsonProperty("capacity")
        int capacity,
        @JsonProperty("qualification")
        String qualification
) {
}
