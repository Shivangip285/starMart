package com.thoughtworks.starMart.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private String name;
    private String surname;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer adminId;
    private String emailId;

    private String password;
}
