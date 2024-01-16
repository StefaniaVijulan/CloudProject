package com.example.auth.controller;


import com.example.auth.dto.UserLogin;
import com.example.auth.dto.UserRequest;
import com.example.auth.dto.UserResponse;
import com.example.auth.model.User;
import com.example.auth.service.UserServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserServiceInt userServiceInt;

    public UserController(UserServiceInt userServiceInt) {
        this.userServiceInt = userServiceInt;
    }


    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody @Valid UserLogin userRequest) throws Exception {
        return userServiceInt.loginUser(userRequest);
    }

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody @Valid UserRequest user) throws Exception {

        System.out.println("Ajungem aici");
        return userServiceInt.registerUser(user);
    }

    @PutMapping
    public UserResponse editUser(@RequestBody UserRequest user) throws Exception {
        return userServiceInt.editUser(user);
    }

    @PutMapping("/change_password")
    public String editPasswordUser(@RequestParam Integer idUser,
                                   @RequestParam  String oldPass,
                                   @RequestParam String newPass ){
        return userServiceInt.editPasswordUser(idUser,oldPass, newPass);
    }

    @DeleteMapping("/{idUser}")
    public String deleteUser(@PathVariable Integer idUser){
        return userServiceInt.deleteUser(idUser);
    }


    @GetMapping
    public User getUser(@RequestParam Integer idUser){
        return  userServiceInt.getUser(idUser);
    }

    @GetMapping("/allOrders")
    public List<Object> getListOfObjects(@RequestParam Integer idUser){
       return userServiceInt.getListOfObjects(idUser);
    }
}
