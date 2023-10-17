package com.pulsar.project.producer.dto;

import com.pulsar.project.producer.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private UserType userType;
}
