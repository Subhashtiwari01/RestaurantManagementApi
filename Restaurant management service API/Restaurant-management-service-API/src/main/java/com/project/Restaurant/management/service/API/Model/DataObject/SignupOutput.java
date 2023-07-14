package com.project.Restaurant.management.service.API.Model.DataObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupOutput {

    boolean signupStatus=true;
    String signUpOutput=null;
}
