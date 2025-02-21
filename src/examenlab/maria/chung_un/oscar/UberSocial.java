/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab.maria.chung_un.oscar;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author chung
 */
public class UberSocial {

    ArrayList<SocialClass> redesSociales = new ArrayList<>();

    private SocialClass buscar(String username, int index) {

        if ( !redesSociales.isEmpty()) {
            if (index >= redesSociales.size()) {
                return null;
            }
            if ( redesSociales.get(index).username.equals(username)) {
                return redesSociales.get(index);
            }
            return buscar(username, index + 1);
        }
        return null;
  
    }

    public SocialClass buscar(String username) {
        return buscar(username, 0);
    }

    public void agregarCuenta(String username, String tipo) {
        SocialClass usuario = buscar(username);
        if (usuario == null) {
            if (tipo.equals("FACEBOOK")) {
                redesSociales.add(new Facebook(username));

            } else if (tipo.equals("TWITTER")) {
                redesSociales.add(new Twitter(username));
            }
        }
    }
    
    public void agregarPost(String user, String post){
        SocialClass usuario= buscar(user);
        if(usuario != null){
           usuario.addPost(post);
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void agregarAmigo(String user1, String user2){
        SocialClass usuario1 = buscar(user1),usuario2 = buscar(user2);
        
        if(usuario1!=null && usuario2!=null){
            boolean resultado1 = usuario1 instanceof Facebook;//false es twitter
            boolean resultado2 = usuario2 instanceof Facebook; //false es twitter
        
            
            if((resultado1 && resultado2) || (!resultado1 && !resultado2)){
                usuario1.addFriend(user2);
                usuario2.addFriend(user1);
            }
            return;
            }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    public void agregarComment(String user, int postID, String autor, String comment){
       SocialClass usuario =  buscar(user);
      
        if (usuario != null) {
            boolean resultado = usuario instanceof Facebook;

            if (resultado == true) {

                Comment comentario = new Comment(postID, autor, comment);
                ((Facebook) usuario).addComment(comentario);
            }
            JOptionPane.showMessageDialog(null, "Cuenta no es de FaceBook", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);

    }
    
    public void profileFrom(String user){
        SocialClass usuario = buscar(user);

        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        usuario.myProfile();
    }
}



