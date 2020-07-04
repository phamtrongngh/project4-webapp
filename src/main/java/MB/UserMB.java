package MB;

import entities.User;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import cookie.CookieHelper;
import javax.faces.context.FacesContext;

/**
 *
 * @author BEN ALPHA
 */
@ManagedBean
@SessionScoped
public class UserMB {

    private User user;
    private WebTarget webTarget; //Cái này dùng để xác định đường dẫn đến API
    private Client client; //Cái này dùng để khởi tạo client để có thể gọi api
    private static final String BASE_URI = "http://localhost:9032/user/"; //Đường dẫn tới api
    private ObjectMapper mapper; //Cái này dùng để chuyển đổi JSON về kiểu thích hợp
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserMB() {
        // Hàm dựng để khởi tạo các biến cần thiết...
        mapper = new ObjectMapper();
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

    public String login() throws IOException {
        webTarget = client.target(BASE_URI + "login"); // Xác định đường dẫn của login trên api
        //Dùng đường dẫn để post thông tin đăng nhập lên api
        String responseJSON = webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON), String.class);
        Map<String, String> responseMap = mapper.readValue(responseJSON, new TypeReference<Map<String, String>>() {
        });
        if (responseMap.get("access_token") == null) {
            return "login";
        }
        if (CookieHelper.getCookie("accessToken") == null) {
            CookieHelper.setCookie("accessToken", "JWT " + responseMap.get("access_token"), 3600);
        }

        return "productList";
    }
    public String logout() {
        webTarget = client.target(BASE_URI + "logout");
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(user, MediaType.APPLICATION_JSON));
        return "login";
    }
}
