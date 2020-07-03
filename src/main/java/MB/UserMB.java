package MB;

import entities.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author BEN ALPHA
 */
@ManagedBean
@SessionScoped
public class UserMB {

    private User user;
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:9032/user/";
    private String jwt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserMB() {
        user = new User();
        client = ClientBuilder.newClient();
    }

    public List<User> getUsers() {
        webTarget = client.target(BASE_URI);
        return webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>() {
        });
    }

    public void register() {
        webTarget = client.target(BASE_URI + "register"); // Xác định đường dẫn của register trên api
        //Dùng đường dẫn để post dữ liệu lên để đăng ký người dùng
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(user, MediaType.APPLICATION_JSON));
    }

    public String login() {
        webTarget = client.target(BASE_URI + "login"); // Xác định đường dẫn của login trên api
        //Dùng đường dẫn để post thông tin đăng nhập lên api
        //Lưu thông tin trả về vào biến userResponse
        jwt = "JWT " + webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON), String.class);
        if (jwt.equals("")) {
            return "login";
        }
        
        return "index";
    }
    public String logout() {
        webTarget = client.target(BASE_URI + "logout");
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(user, MediaType.APPLICATION_JSON));
        return "login";
    }
}
