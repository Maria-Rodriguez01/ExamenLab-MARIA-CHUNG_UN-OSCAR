/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab.maria.chung_un.oscar;

import java.util.Calendar;

/**
 *
 * @author chung
 */
public final class Comment {
    int postId;
    String autor, contenidoComentario;
    Calendar fecha;

    public Comment(int postId, String autor, String contenidoComentario) {
        this.postId = postId;
        this.autor = autor;
        this.contenidoComentario = contenidoComentario;
        fecha = Calendar.getInstance();
    }
    
    public String print(){
        return autor + "-" + fecha.toString() + "\n" + contenidoComentario;
    }
}
