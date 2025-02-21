/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab.maria.chung_un.oscar;

/**
 *
 * @author LENOVO
 */
public class Twitter extends SocialClass {

    public Twitter(String username) {
        super(username);
    }

    @Override
    public void timeline() {
        for (String post : posts){
            System.out.println(post);
        }
    }
    
}
