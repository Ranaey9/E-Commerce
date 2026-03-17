package com.java.e_ticaret_nisan.entitiy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class dtoUser {

    private String name;
    private String surname;
    private String email;
    private String password;


}
