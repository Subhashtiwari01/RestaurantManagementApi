package com.project.Restaurant.management.service.API.Service;

import com.project.Restaurant.management.service.API.Model.AuthenticationToken;
import com.project.Restaurant.management.service.API.Model.DataObject.SignInInput;
import com.project.Restaurant.management.service.API.Model.DataObject.SignupOutput;
import com.project.Restaurant.management.service.API.Model.User;
import com.project.Restaurant.management.service.API.Repository.IAuthTokenRepo;
import com.project.Restaurant.management.service.API.Repository.IUserRepo;
import com.project.Restaurant.management.service.API.Service.HashingUtility.PasswordEncryption;
import com.project.Restaurant.management.service.API.Service.emailUtility.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.StringReader;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    IAuthTokenRepo authTokenRepo;


    public Iterable<User> findAll() {
        return userRepo.findAll();
    }
    public SignupOutput userSignup(User user) throws NoSuchAlgorithmException {


        User newEmail=userRepo.findFirstByGmail(user.getGmail());

        boolean signupStatus=true;
        String signUpOutput=null;
//        SignupOutput signupResponse=null;

        // check user is already  exist or not
        if(newEmail!=null){
//            System.out.println("Email already exist");
            signupStatus =false;
            signUpOutput = "Email already exist";
            return new SignupOutput(signupStatus,signUpOutput);

        }

        // encrypt the password
         String encryptedPassword=PasswordEncryption.encryptionpassword(user.getUserPassword());

        // now save user with encrypted password
        user.setUserPassword(encryptedPassword);
        userRepo.save(user);

        signupStatus =true;
        signUpOutput = "User registered successfully";


        return new SignupOutput(signupStatus,signUpOutput);




    }

    //session should be created since password matched and user id is valid

    public String userSigIn( SignInInput signInInput) {
        String signInStatusMessage=null;

        String signInEmail=signInInput.getUserEmail();

        if(signInEmail==null){
            signInStatusMessage="Invalid Email";
            return signInStatusMessage;
        }
        //check if this User email already exists ??

        User existingUser=userRepo.findFirstByGmail(signInEmail);

        if(existingUser==null){
            signInStatusMessage="Email Not Registered";
            return signInStatusMessage;
        }
        //match passwords :

        //hash the password: encrypt the password
        try{
            String encryptedPassword=PasswordEncryption.encryptionpassword(signInInput.getUserPassword());
            if (existingUser.getUserPassword().equals(encryptedPassword)){
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken=new AuthenticationToken(existingUser);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else{
                signInStatusMessage="Invlid Email";
                return signInStatusMessage;
            }
        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }



    }


































    public String deleteUser(User user) {
         userRepo.delete(user);
        return"User Deleted";
    }

    public String updateUser(User user) {
         userRepo.save(user);
        return"Information Updated";
    }


}
