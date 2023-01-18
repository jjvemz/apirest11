package com.demo.apirest.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="users")
public class Users {



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Id
    @SequenceGenerator(
            name="users_generator",
            sequenceName = "users_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_generator"
    )
    private Long Id;
    private String name;
    private  String email;
    private  String password;
    private LocalDate modified;
    private  Boolean isActive;

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @OneToOne(mappedBy = "users")
    private Phone phone;

    public Users(Long Id, String name,String email,String password,LocalDate modified,Boolean isActive){
        this.Id= Id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.modified =modified;
        this.isActive = isActive;
    }

}
