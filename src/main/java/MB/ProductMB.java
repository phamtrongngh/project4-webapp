/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import entities.Product;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import cookie.CookieHelper;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Cookie;
/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class ProductMB {

    private Product product;
    private WebTarget webTarget;
    private Client client;
    private Builder builder;
    private String cookie;
    private static final String BASE_URI = "http://localhost:9032/product/";

    public ProductMB() {
        product = new Product();
        client = ClientBuilder.newClient();
        if (CookieHelper.getCookie("accessToken")==null){
            cookie="";
        }else{
            cookie = CookieHelper.getCookie("accessToken").getValue();
        }
        builder = client.target(BASE_URI)
                        .request(MediaType.APPLICATION_JSON)
                        .header("authorization", cookie);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        List<Product> list;
        list = builder.get(new GenericType<List<Product>>() {
        });
        return list;
    }

    
    public String postProuct(){
        builder.post(Entity.entity(this.product, MediaType.APPLICATION_JSON));
        return "productList";
    }
    
    public Product getProduct(String id){
        webTarget = client.target(BASE_URI + id);
        product = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<Product>(){});      
        return product;
    }
    
    public String putProduct(){
        webTarget = client.target(BASE_URI);
        webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(this.product, MediaType.APPLICATION_JSON));
        return "productList";
    }
    
    public void deleteProduct(String id){
        webTarget = client.target(BASE_URI + id);
        builder.delete(new GenericType<Product>(){});
    }

}
