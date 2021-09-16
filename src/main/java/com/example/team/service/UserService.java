package com.example.team.service;

import com.example.team.entities.Address;
import com.example.team.entities.User;
import com.example.team.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        User newUser = new User();
        newUser.setFname(user.getFname());
        newUser.setLname(user.getLname());
        newUser.setEmail(user.getEmail());
        newUser.setContact(user.getContact());
        // Adding addresses in user
        for(int i=0; i<user.getAddresses().size(); i++) {
            newUser.getAddresses().add(user.getAddresses().get(i));
        }
        return this.userRepository.save(user);
    }

    public User updateUser(User user) {
        if(userRepository.findById(user.getId()).isPresent()) {
            User newUser = userRepository.findById(user.getId()).get();
            newUser.setFname(user.getFname());
            newUser.setLname(user.getLname());
            newUser.setEmail(user.getEmail());
            newUser.setContact(user.getContact());
            return userRepository.save(newUser);
            //return ResponseEntity.ok().body("Successfully updated the user");
        }
        return null;
    }

    public String deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()) {
            User newUser = userRepository.findById(id).get();
            List<Address> addresses = newUser.getAddresses();
//            for(int i=0; i<addresses.size(); i++) {
//                for(User user: addresses.get(i).getUsers()) {
//                    if(user.getId()==id) {
//                        addresses.get(i).getUsers().remove(user);
//                    }
//                }
//            }
            userRepository.deleteById(id);
            return newUser.toString();
        }
        return "User does not exist!!!";
    }


}
