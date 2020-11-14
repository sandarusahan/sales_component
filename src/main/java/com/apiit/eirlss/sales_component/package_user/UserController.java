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
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/signup")
    public void signUp(@RequestBody User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/changepw")
    public void changePassword(@RequestBody User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PostMapping(value="/checkpw")
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
    
    @GetMapping(value="/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }
    
    @PutMapping(value="update/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        
        User existsUser = userRepository.findByUsername(username);
        existsUser.setEmergencyContact(user.getEmergencyContact());
        existsUser.setAddress(user.getAddress());
        existsUser.setMobile(user.getMobile());
        existsUser.setName(user.getName());
        existsUser.setUserAccess(user.getUserAccess());
        
        return userRepository.save(existsUser);
        
    }
}