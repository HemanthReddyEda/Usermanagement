package com.Ecommerce_website.Usermanagement.service;

import com.Ecommerce_website.Usermanagement.Config.Ordermodel;
import com.Ecommerce_website.Usermanagement.Config.Productmodel;
import com.Ecommerce_website.Usermanagement.Feignclients.Ordersclient;
import com.Ecommerce_website.Usermanagement.Feignclients.Productcatalogclient;
import com.Ecommerce_website.Usermanagement.model.User;
import com.Ecommerce_website.Usermanagement.repository.Userrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {
    @Autowired
    private Userrepo userrepo;

    public String registerUser(User user) {
        user.setPassword(user.getPassword());
        userrepo.save(user);
        return "User registered successfully";
    }

    public String loginUser(String name, String password) {
        Optional<User> userOptional = userrepo.findByName(name);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if the provided password matches the stored password
            if (user.getPassword().equals(password)) {
                return "User logged in successfully";
            } else {
                return "Invalid password";
            }
        }
        return "";
    }
//****************************Autowired-product-catalog-client**********************************
    @Autowired
    private Productcatalogclient productcatalogclient;
    public String addproduct(Productmodel product) {
        return productcatalogclient.addproduct(product);
    }

    public String updateprice(Integer id, Long price) {
        return productcatalogclient.updateprice(id, price);
    }

    public String updatequantity(Integer id, Integer quantity) {
        return productcatalogclient.updatequantity(id, quantity);
    }

    public String deleteproduct(Integer id) {
        return productcatalogclient.deleteproduct(id);
    }

    public List<Productmodel> getallproducts() {
        return productcatalogclient.getallproducts();
    }

    public List<Productmodel> getproductbycategory(String category) {
        return productcatalogclient.getproductbycategory(category);
    }

    public List<Productmodel> getproductunderprice(Long price) {
        return productcatalogclient.getproductunderprice(price);
    }
//*******************************Autowired-Orderscliect***********************************
    @Autowired
    private Ordersclient ordersclient;
    public Optional<Ordermodel> getorderbyid(Integer orderid) {
        return ordersclient.getorderbyid(orderid);
    }

    public Ordermodel updateorderstatus(Integer orderid, String orderStatus) {
        return ordersclient.updateorderstatus(orderid, orderStatus);
    }

    public void deleteorder(Integer orderid) {
        ordersclient.deleteorder(orderid);
    }

    public Ordermodel placeorder(Integer id, Ordermodel ordermodel) {
        return ordersclient.placeorder(ordermodel);
    }

    public List<Ordermodel> getallorders() {
        return ordersclient.getallorders();
    }
}
