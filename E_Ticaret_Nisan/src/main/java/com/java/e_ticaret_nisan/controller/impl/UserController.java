package com.java.e_ticaret_nisan.controller.impl;

import com.java.e_ticaret_nisan.Service.IUserService;
import com.java.e_ticaret_nisan.controller.IUserController;
import com.java.e_ticaret_nisan.entitiy.dto.dtoUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/user")
public class UserController implements IUserController {

    @Autowired
    private IUserService userService;

    @Override
    @PostMapping("/save")
    public dtoUser saveUser(@RequestBody @Valid dtoUser user) {
        return userService.saveUser(user);
    }

    @Override
    @GetMapping("/get/{id}")
    public dtoUser getUserById(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @Override
    @PatchMapping("/update/{id}")
    public dtoUser updateUser(@PathVariable(name = "id") Long id,@RequestBody dtoUser user) {
        return userService.updateUser(id,user);
    }


}
