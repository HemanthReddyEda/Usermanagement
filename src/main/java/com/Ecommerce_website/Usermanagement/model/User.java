package com.Ecommerce_website.Usermanagement.model;

import com.Ecommerce_website.Usermanagement.Config.Productmodel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int userid;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String role;
}

