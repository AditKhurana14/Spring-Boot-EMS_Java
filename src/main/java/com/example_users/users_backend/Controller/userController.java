package com.example_users.users_backend.Controller;

import com.example_users.users_backend.Service.userService;
import com.example_users.users_backend.responseDto.responseDto;
import com.example_users.users_backend.userDTO.userDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000/")
@RestController
public class userController {
    private userService service;

    public userController(userService service) {
        this.service = service;
    }

    @GetMapping("/getallemployee")
    public List<userDto> getAllUsers() {
        return service.findAll();

    }

    @GetMapping("/getemployee/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        userDto user = service.findUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new responseDto("No Employee Present"));
        }

    }

    @PostMapping("/employee")
    public ResponseEntity<responseDto> addUser(@RequestBody userDto user) {
        service.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new responseDto("Employee saved successfully"));


    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<responseDto> deleteUser(@PathVariable int id) {
       boolean response= service.deleteUser(id);
       if(response==true){
           return ResponseEntity.ok().body(new responseDto("Employee Deleted"));


       }
       else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new responseDto("No Employee Present"));
       }



    }

    @PutMapping("updateEmployee/{id}")
    public ResponseEntity  updateUser (@PathVariable int id,@RequestBody userDto user){

        userDto userResponse=service.updateUser(id,user);
        if(userResponse==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new responseDto("No Employee Present"));


        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(new responseDto("Employee Updated"));


        }



    }





}
