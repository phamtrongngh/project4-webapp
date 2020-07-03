/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

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
    }
    
        public List<Restaurant> getRestaurants(){
        webTarget = client.target(BASE_URI);
        List<Restaurant> list;
        list = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Restaurant>>(){
        });
        return list;
    }
    
    public String postRestaurant(){
        webTarget = client.target(BASE_URI);
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(this.restaurant, MediaType.APPLICATION_JSON));
        return "restaurantList";
    }
    
    public Restaurant getRestaurant(String id){
        webTarget = client.target(BASE_URI + id);
        restaurant = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<Restaurant>(){});      
        return restaurant;
    }
    
    public String putRestaurant(){
        webTarget = client.target(BASE_URI);
        webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(this.restaurant, MediaType.APPLICATION_JSON));
        return "restaurantList";
    }
    
    public void deleteRestaurant(String id){
        webTarget = client.target(BASE_URI + id);
        webTarget.request(MediaType.APPLICATION_JSON).delete(new GenericType<Restaurant>(){});
    } 
    
}
