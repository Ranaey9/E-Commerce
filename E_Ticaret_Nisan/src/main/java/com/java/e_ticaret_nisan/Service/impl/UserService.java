package com.java.e_ticaret_nisan.Service.impl;

import com.java.e_ticaret_nisan.Service.IUserService;
import com.java.e_ticaret_nisan.entitiy.Role;
import com.java.e_ticaret_nisan.entitiy.User;
import com.java.e_ticaret_nisan.entitiy.dto.dtoUser;
import com.java.e_ticaret_nisan.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public dtoUser saveUser(dtoUser user) {

        String mail = user.getEmail();
        if (userRepository.existsByEmail(mail)){
            throw new RuntimeException("Bu email zaten kayıtlı.");
        }
        User saveuser = new User();
        BeanUtils.copyProperties(user,saveuser);
        saveuser.setRole(Role.Customer);
        User save = userRepository.save(saveuser);
        dtoUser returnuser = new dtoUser();

        BeanUtils.copyProperties(save,returnuser);
        return returnuser;
    }

    @Override
    public dtoUser getUserById(Long id) {
        User user = userRepository.findById(id).get();
        dtoUser dtoUser = new dtoUser();
        BeanUtils.copyProperties(user,dtoUser);
        return dtoUser;
    }

    @Override
    public dtoUser updateUser(Long id, dtoUser user) {

        if (user.getEmail()!=null){
            throw new RuntimeException("Mailinizi değiştiremezsiniz");
        }
        Optional<User> optional = userRepository.findById(id);
        if (!optional.isPresent()){
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
        User update = optional.get();
        if (user.getName()!=null){
            update.setName(user.getName());
        }if (user.getSurname()!=null){
            update.setSurname(user.getSurname());
        }if (user.getPassword()!=null){
            update.setPassword(user.getPassword());
        }
        dtoUser dtoUser = new dtoUser();
        BeanUtils.copyProperties(update,dtoUser);

        return dtoUser;
    }
}
