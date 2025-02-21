/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab.maria.chung_un.oscar;

import java.util.ArrayList;

/**
 *
 * @author chung
 */
public abstract class SocialClass {
    ArrayList <String> friend;
    ArrayList <String> posts;
    String username;
    
    public SocialClass(String username){
    this.username= username;
    posts = new ArrayList<>();
    friend = new ArrayList<>();
    }
    
    public boolean addFriend(String user){
        if(friend.contains(user)){
            return false;
        }
        friend.add(user);
        return true;
    }
    
    public void addPost(String msg){
    posts.add(msg);
    }
    
    public abstract void timeline();
    
    public void myProfile(){
        //pending 
    }
}
