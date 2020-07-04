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
public class Newfeed {
    private String _id;
    private List<User> idUser;
    private List<Restaurant> idRes;
    private String content; 
    private String images; 
    private List<User> likes;
    private List<String> comments;
    private boolean typed;
    private Date createdAt;
    private Date updatedAt;
    private int __v; 

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<User> getIdUser() {
        return idUser;
    }

    public void setIdUser(List<User> idUser) {
        this.idUser = idUser;
    }

    public List<Restaurant> getIdRes() {
        return idRes;
    }

    public void setIdRes(List<Restaurant> idRes) {
        this.idRes = idRes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
    
    public boolean isTyped() {
        return typed;
    }

    public void setTyped(boolean typed) {
        this.typed = typed;
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

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
