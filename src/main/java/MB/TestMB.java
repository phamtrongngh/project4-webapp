/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import cookie.CookieHelper;
/**
 *
 * @author BEN ALPHA
 */
@ManagedBean
@RequestScoped
public class TestMB {

    /**
     * Creates a new instance of TestMB
     */
    public TestMB() {
    }
    public String login() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
//        Cookie cookie = null;
//        cookie = new Cookie("newCookie", "123456");
//        cookie.setMaxAge(3600);
//        cookie.setPath(request.getContextPath());
//        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//        response.addCookie(cookie);
        CookieHelper.setCookie("nesssw", "JWT eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZWY3YjVmNDI5YjZlNTM3MjRmMzY5MTQiLCJmdWxsbmFtZSI6Ik5naGlhIEhvYW5nIiwiaWF0IjoxNTkzODU4NjIyLCJleHAiOjE1OTM4Njk0MjJ9._clvieOae4T1FK_rmiIA4AgEU7aDDyBrJL16qddaPkw", 3600);
        return "index";
    }
}
