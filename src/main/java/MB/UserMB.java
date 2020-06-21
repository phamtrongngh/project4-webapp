/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import entities.User;
import java.io.IOException;
import java.util.List;
import javafx.scene.media.Media;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author BEN ALPHA
 */
@ManagedBean
@RequestScoped
public class UserMB {

    public List<User> getUsers() throws IOException {
        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource("http://localhost:9032/user");
        Builder builder = webResource.accept(MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error = response.getEntity(String.class);
            System.out.println("Error" + error);
        }
        ObjectMapper mapper = new ObjectMapper();
        List<User> list =mapper.readValue(response.getEntity(String.class), new TypeReference<List<User>>(){});
       
        return list;
    }
}
