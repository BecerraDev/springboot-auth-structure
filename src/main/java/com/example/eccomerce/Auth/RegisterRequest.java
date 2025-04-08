package com.example.eccomerce.Auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	
     private String username;
     private String lastname;
     private String firstname;
     private String password;
     private String email;
     private String country;
     
	
}