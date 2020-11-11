package com.apiit.eirlss.sales_component.package_user;

import javax.persistence.*; 

@Entity(name = "User")
@Table(name = "user")
public class User
{

    public User()
    {

    }
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private UserRole role = UserRole.EMPLOYEE;


    enum UserRole {
        ADMIN,
        EMPLOYEE
    }
    public long getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    
}