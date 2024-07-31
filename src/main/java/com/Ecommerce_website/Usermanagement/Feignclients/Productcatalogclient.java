package com.Ecommerce_website.Usermanagement.Feignclients;

import com.Ecommerce_website.Usermanagement.Config.Ordermodel;
import com.Ecommerce_website.Usermanagement.Config.Productmodel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="product-catalog", url="http://localhost:8082")
public interface Productcatalogclient {

    @PostMapping("/product/admin/addproduct")
    String addproduct(@RequestBody Productmodel product);

    @PutMapping("/product/admin/update-price/{id}")
    String updateprice(@PathVariable("id") Integer id, @RequestParam Long price);

    @PutMapping("/product/admin/update-quantity/{id}")
    String updatequantity(@PathVariable("id") Integer id, @RequestParam Integer quantity);

    @DeleteMapping("/product/admin/delete-product/{id}")
    String deleteproduct(@PathVariable("id") Integer id);

    @GetMapping("/product/getallproducts")
    List<Productmodel> getallproducts();

    @GetMapping("/product/getproduct/{category}")
    List<Productmodel> getproductbycategory(@PathVariable("category") String category);

    @GetMapping("/product/getproduct/under-price/{price}")
    List<Productmodel> getproductunderprice(@PathVariable("price") Long price);

    @PostMapping("/getproduct/{id}/orders/placeorder")
    public Ordermodel placeorder(@PathVariable("id") Integer id, @RequestBody Ordermodel ordermodel);
}
