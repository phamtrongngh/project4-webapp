/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author BEN ALPHA
 */
@ManagedBean
@RequestScoped
public class MessageMB {
    private String content;
    public String getContent() {
        
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void sendMessage(){
        
    }
    public void getMessages(){
        
    }
}
