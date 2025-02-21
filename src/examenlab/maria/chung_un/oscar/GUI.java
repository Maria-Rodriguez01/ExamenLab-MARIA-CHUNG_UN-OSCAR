/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab.maria.chung_un.oscar;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author chung
 */
public class GUI extends JFrame {

    public GUI(UberSocial sistema) {
        setLayout(new GridLayout(0, 2));
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnFaceBook = new JButton("FaceBook");
        JButton btnTwitter = new JButton("Twitter");

        btnFaceBook.addActionListener(e -> {
            removeAll();
            // inicia panel
            revalidate();
            repaint();
        });

        btnTwitter.addActionListener(e -> {
            removeAll();
            // inicia panel
            revalidate();
            repaint();
        });

        add(btnFaceBook);
        add(btnTwitter);

        setVisible(true);

    }
}

class panelTwitter extends JPanel{
    
    public panelTwitter(){
    setBackground(Color.WHITE);
    
}}


