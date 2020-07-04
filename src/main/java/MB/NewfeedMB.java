/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

import entities.Newfeed;
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
public class NewfeedMB {
    private Newfeed newfeed;
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:9032/newfeed/";
    /**
     * Creates a new instance of NewfeedMB
     */
    public NewfeedMB() {
        newfeed = new Newfeed();
        client = ClientBuilder.newClient();
    }

    public Newfeed getNewfeed() {
        return newfeed;
    }

    public void setNewfeed(Newfeed newfeed) {
        this.newfeed = newfeed;
    }
        public List<Newfeed> getNewfeeds(){
        webTarget = client.target(BASE_URI);
        List<Newfeed> list;
        list = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Newfeed>>(){
        });
        return list;
    }
    
    public String postNewfeed(){
        webTarget = client.target(BASE_URI);
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(this.newfeed, MediaType.APPLICATION_JSON));
        return "";
    }
    
    public Newfeed getNewfeed(String id){
        webTarget = client.target(BASE_URI + id);
        newfeed = webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<Newfeed>(){});      
        return newfeed;
    }
    
    public String putnewfeed(){
        webTarget = client.target(BASE_URI);
        webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(this.newfeed, MediaType.APPLICATION_JSON));
        return "";
    }
    
    public void deletenewfeed(String id){
        webTarget = client.target(BASE_URI + id);
        webTarget.request(MediaType.APPLICATION_JSON).delete(new GenericType<Newfeed>(){});
    }
    
}
