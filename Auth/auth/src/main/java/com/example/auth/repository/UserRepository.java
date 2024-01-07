package com.example.auth.repository;

import com.example.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //  User getUserByUsernameUserAndPasswordUser(String username, String password);

    @Query("select a from user a where a.usernameUser =:username and a.passwordUser= :pass")
    User findUserByUsernameUserAndPasswordUser(String username, String pass);

    @Query("select a from user a where a.usernameUser =:username")
    User findUserByUsernameUser(String username);
}
