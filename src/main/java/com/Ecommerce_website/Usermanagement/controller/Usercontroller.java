package com.Ecommerce_website.Usermanagement.controller;

import com.Ecommerce_website.Usermanagement.Config.Ordermodel;
import com.Ecommerce_website.Usermanagement.Config.Productmodel;
import com.Ecommerce_website.Usermanagement.service.Userservice;
import com.Ecommerce_website.Usermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Usercontroller {
    //*************************USER-CONTROLLER**********************************************
    @Autowired
    private Userservice userservice;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userservice.registerUser(user);
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String name,@RequestParam String password){
        return userservice.loginUser(name,password);
    }

    //************************PRODUCT-CATALOG-CONTROLLER***************************************

    @PostMapping("/product/admin/addproduct")
    public String addProduct(@RequestBody Productmodel product) {
        return userservice.addproduct(product);
    }

    @PutMapping("/product/admin/update-price/{id}")
    public String updatePrice(@PathVariable Integer id, @RequestParam Long price) {
        return userservice.updateprice(id, price);
    }

    @PutMapping("/product/admin/update-quantity/{id}")
    public String updateQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
        return userservice.updatequantity(id, quantity);
    }

    @DeleteMapping("/product/admin/delete-product/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return userservice.deleteproduct(id);
    }


    @GetMapping("/product/getallproducts")
    public List<Productmodel> getAllProducts() {
        return userservice.getallproducts();
    }

    @GetMapping("/product/getproduct/{category}")
    public List<Productmodel> getProductByCategory(@PathVariable String category) {
        return userservice.getproductbycategory(category);
    }

    @GetMapping("/product/getproduct/under-price/{price}")
    public List<Productmodel> getProductUnderPrice(@PathVariable Long price) {
        return userservice.getproductunderprice(price);
    }

    @PostMapping("/getproduct/{id}/orders/placeorder")
    public Ordermodel placeorder(@PathVariable("id") Integer id, @RequestBody Ordermodel ordermodel){
        return userservice.placeorder(id,ordermodel);
    }

    //*********************************ORDERS-CONTROLLER***********************************

    @GetMapping("/orders/getorder/{iD}")
    public Optional<Ordermodel> getorderbyid(@PathVariable("iD") Integer orderid){
        return userservice.getorderbyid(orderid);
    }
    @PutMapping("/product/admin/orders/updateorder/{orderid}/{status}")
    public Ordermodel updateorderstatus(@PathVariable("orderid") Integer orderid,@PathVariable("status") String order_status){
        return userservice.updateorderstatus(orderid,order_status);
    }
    @DeleteMapping("/orders/cancelorder/{orderid}")
    public void deleteorder(@PathVariable("orderid") Integer orderid){
        userservice.deleteorder(orderid);
    }
    @GetMapping("/admin/orders/getallorders")
    public List<Ordermodel> getallorders(){
        return userservice.getallorders();
    }
}
