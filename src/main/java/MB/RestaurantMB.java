/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

import cookie.CookieHelper;
import entities.Restaurant;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Admin
 */
@ManagedBean
@RequestScoped
public class RestaurantMB {
    private Restaurant restaurant;
    private WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://localhost:9032/restaurant/";
    private String jwt;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    public RestaurantMB() {
        restaurant = new Restaurant();
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI);
    }
    
        public List<Restaurant> getRestaurants(){
        return webTarget.request(MediaType.APPLICATION_JSON)
                .header("authorization", CookieHelper.getCookie("accessToken"))
                .get(new GenericType<List<Restaurant>>(){});
    }
    
    public String postRestaurant(){
        webTarget.request(MediaType.APPLICATION_JSON)
                .header("authorization", CookieHelper.getCookie("accessToken"))
                .post(Entity.entity(this.restaurant, MediaType.APPLICATION_JSON_TYPE));        
        return "restaurantList";
    }
    
    public Restaurant getRestaurant(String id){
        restaurant = webTarget.path(id)
                              .request(MediaType.APPLICATION_JSON)
                              .header("authorization", CookieHelper.getCookie("accessToken"))
                              .get(new GenericType<Restaurant>(){});
        return restaurant;
    }
    
    public String putRestaurant(){
        webTarget.request(MediaType.APPLICATION_JSON)
                 .header("authorization", CookieHelper.getCookie("accessToken"))
                 .put(Entity.entity(this.restaurant, MediaType.APPLICATION_JSON));
        return "restaurantList";
    }
    
    public void deleteRestaurant(String id){
        webTarget.path(id)
                 .request(MediaType.APPLICATION_JSON)
                 .header("authorization", CookieHelper.getCookie("accessToken"))
                 .delete();
    } 
    
}
