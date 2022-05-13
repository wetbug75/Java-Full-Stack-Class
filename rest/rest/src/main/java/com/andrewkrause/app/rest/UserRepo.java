package com.andrewkrause.app.rest;

//import com.andrewkrause.app.rest.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
