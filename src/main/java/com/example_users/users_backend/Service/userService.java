package com.example_users.users_backend.Service;

import com.example_users.users_backend.userDTO.userDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class userService {
    private int idCount=3;

    public static List<userDto> users = new ArrayList<>();

    static {
        users.add(new userDto(1, "Adit", "Khurana", "aditkhurana14@gmail.com"));
        users.add(new userDto(2, "Ankit", "Khurana", "ankitkhurana14@gmail.com"));
        users.add(new userDto(3, "Arun", "Khurana", "arunkhurana14@gmail.com"));


    }

    public List<userDto> findAll() {

        return users;
    }
    public userDto findUser(int id) {
        return users.stream()
                .filter(userDto -> userDto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addUser(userDto user){
        user.setId(++idCount);
        users.add(user);



    }

    public boolean deleteUser(int id) {
        boolean exists = users.stream().anyMatch(user -> user.getId() == id);
        if (exists) {
            users.removeIf(user -> user.getId() == id);
        }
        return exists; // Returns true if deleted, false if id was not found
    }
    public userDto updateUser(int id, userDto userDto) {
     Optional<userDto>user=users.stream().filter(user1->user1.getId()==id).findFirst();
     if(user.isPresent()){
         userDto existingUser=user.get();
         existingUser.setFirst_name(userDto.getFirst_name());
         existingUser.setLast_name(userDto.getLast_name());
         existingUser.setEmail(userDto.getEmail());

         return existingUser;

     }
        return null; // Or throw a custom exception
    }





}

