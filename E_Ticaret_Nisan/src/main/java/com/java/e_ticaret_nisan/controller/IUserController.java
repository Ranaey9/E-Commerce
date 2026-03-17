package com.java.e_ticaret_nisan.controller;

import com.java.e_ticaret_nisan.entitiy.User;
import com.java.e_ticaret_nisan.entitiy.dto.dtoUser;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUserController {

    public dtoUser saveUser(dtoUser user);
    public dtoUser getUserById(Long id);
    public dtoUser updateUser(Long id,dtoUser user);

}
