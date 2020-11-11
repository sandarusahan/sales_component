package com.apiit.eirlss.sales_component.package_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/signup")
    public void signUp(@RequestBody User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PutMapping("/changepw")
    public void changePassword(@RequestBody User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @GetMapping(value="/checkpw")
    public boolean checkPassword(@RequestBody User user) {
        User existUser = userRepository.findByUsername(user.getUsername());
        if(bCryptPasswordEncoder.encode(user.getPassword()) == existUser.getPassword()){
            return true;
        }else {
            return false;
        }
        
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value="/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    
}