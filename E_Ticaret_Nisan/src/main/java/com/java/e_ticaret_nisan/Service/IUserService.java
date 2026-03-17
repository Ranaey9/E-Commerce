package com.java.e_ticaret_nisan.Service;

import com.java.e_ticaret_nisan.entitiy.dto.dtoUser;

public interface IUserService {


    public dtoUser saveUser(dtoUser user);
    public dtoUser getUserById(Long id);
    public dtoUser updateUser(Long id,dtoUser user);

}
