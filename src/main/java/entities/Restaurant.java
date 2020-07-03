/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Restaurant {
    private String _id;
    private String name; 
    private List<User> managers;
    private List<Newfeed> newfeeds;
    private List<Product> menus;
    private String address; 
    private boolean verified;
    private String avatar;
    private List<User> followers; 
    private boolean timestamps;
    private Date createdAt;
    private Date updatedAt;
    private int __v;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getManagers() {
        return managers;
    }

    public void setManagers(List<User> managers) {
        this.managers = managers;
    }

    public List<Newfeed> getNewfeeds() {
        return newfeeds;
    }

    public void setNewfeeds(List<Newfeed> newfeeds) {
        this.newfeeds = newfeeds;
    }

    public List<Product> getMenus() {
        return menus;
    }

    public void setMenus(List<Product> menus) {
        this.menus = menus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public boolean isTimestamps() {
        return timestamps;
    }

    public void setTimestamps(boolean timestamps) {
        this.timestamps = timestamps;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int get__V() {
        return __v;
    }

    public void set__V(int __v) {
        this.__v = __v;
    }

   
    
}
