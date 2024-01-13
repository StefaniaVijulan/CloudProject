package com.example.auth.service;

import com.example.auth.dto.UserLogin;
import com.example.auth.dto.UserRequest;
import com.example.auth.dto.UserResponse;
import com.example.auth.model.User;

import java.util.List;

public interface UserServiceInt  {

    public UserResponse loginUser(UserLogin user);
    public UserResponse registerUser(UserRequest User) ;
    public UserResponse editUser(UserRequest User);
    public String editPasswordUser(Integer idUser,String oldPass, String newPass);
    public String deleteUser(Integer idUser);
    public User getUser(Integer idUser);
    public List<Object> getListOfObjects(Integer idUser);
//    public List<Order> orderList(Integer idUser);
}
