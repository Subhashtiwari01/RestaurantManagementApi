package com.project.Restaurant.management.service.API.Model.DataObject;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {

    @NotNull
    @Column(unique = true)
    private String userEmail;
    private String userPassword;

}
