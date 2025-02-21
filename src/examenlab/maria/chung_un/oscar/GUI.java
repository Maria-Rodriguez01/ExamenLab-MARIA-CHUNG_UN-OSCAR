/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab.maria.chung_un.oscar;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
    private UberSocial socialSystem;
    private JTextArea outputArea;
    
    public GUI() {
        socialSystem = new UberSocial();
        
        setTitle("Sistema de Redes Sociales");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Panel de control
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Acciones"));
        
        // Panel para agregar cuenta
        JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        accountPanel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField(10);
        accountPanel.add(usernameField);
        accountPanel.add(new JLabel("Tipo:"));
        JComboBox<String> accountTypeCombo = new JComboBox<>(new String[]{"FACEBOOK", "TWITTER"});
        accountPanel.add(accountTypeCombo);
        JButton addAccountBtn = new JButton("Crear Cuenta");
        accountPanel.add(addAccountBtn);
        controlPanel.add(accountPanel);
        
        // Panel para agregar post
        JPanel postPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        postPanel.add(new JLabel("Usuario:"));
        JTextField userPostField = new JTextField(10);
        postPanel.add(userPostField);
        postPanel.add(new JLabel("Post:"));
        JTextField postField = new JTextField(15);
        postPanel.add(postField);
        JButton addPostBtn = new JButton("Agregar Post");
        postPanel.add(addPostBtn);
        controlPanel.add(postPanel);
        
        // Panel para agregar amigo
        JPanel friendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        friendPanel.add(new JLabel("Usuario 1:"));
        JTextField user1Field = new JTextField(10);
        friendPanel.add(user1Field);
        friendPanel.add(new JLabel("Usuario 2:"));
        JTextField user2Field = new JTextField(10);
        friendPanel.add(user2Field);
        JButton addFriendBtn = new JButton("Agregar Amigo");
        friendPanel.add(addFriendBtn);
        controlPanel.add(friendPanel);
        
        // Panel para agregar comentario
        JPanel commentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        commentPanel.add(new JLabel("Usuario:"));
        JTextField userCommentField = new JTextField(10);
        commentPanel.add(userCommentField);
        commentPanel.add(new JLabel("Post ID:"));
        JTextField postIdField = new JTextField(3);
        commentPanel.add(postIdField);
        commentPanel.add(new JLabel("Autor:"));
        JTextField authorField = new JTextField(8);
        commentPanel.add(authorField);
        JButton addCommentBtn = new JButton("Comentar");
        controlPanel.add(commentPanel);
        
        JPanel commentContentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        commentContentPanel.add(new JLabel("Comentario:"));
        JTextField commentField = new JTextField(25);
        commentContentPanel.add(commentField);
        commentContentPanel.add(addCommentBtn);
        controlPanel.add(commentContentPanel);
        
        // Panel para ver perfil
        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        profilePanel.add(new JLabel("Ver perfil de:"));
        JTextField profileField = new JTextField(10);
        profilePanel.add(profileField);
        JButton viewProfileBtn = new JButton("Ver Perfil");
        profilePanel.add(viewProfileBtn);
        controlPanel.add(profilePanel);
        
        // Panel de salida
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        mainPanel.add(controlPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
                
        // Acción para agregar cuenta
        addAccountBtn.addActionListener(e -> {
            String username = usernameField.getText().trim();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario no puede estar vacío");
                return;
            }
            
            String type = (String) accountTypeCombo.getSelectedItem();
            socialSystem.agregarCuenta(username, type);
            outputArea.append("Cuenta " + type + " creada para " + username + "\n");
            usernameField.setText("");
        });
        
        // Acción para agregar post
        addPostBtn.addActionListener(e -> {
            String user = userPostField.getText().trim();
            String post = postField.getText().trim();
            
            if (user.isEmpty() || post.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El usuario y el post no pueden estar vacíos");
                return;
            }
            
            socialSystem.agregarPost(user, post);
            outputArea.append("Post agregado a la cuenta de " + user + "\n");
            postField.setText("");
            userPostField.setText("");
        });
        
        // Acción para agregar amigo
        addFriendBtn.addActionListener(e -> {
            String user1 = user1Field.getText().trim();
            String user2 = user2Field.getText().trim();
            
            if (user1.isEmpty() || user2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ambos usuarios son requeridos");
                return;
            }
            
            if (user1.equals(user2)) {
                JOptionPane.showMessageDialog(this, "No se puede agregar a sí mismo como amigo");
                return;
            }
            
            socialSystem.agregarAmigo(user1, user2);
            SocialClass account = socialSystem.buscar(user1);
            if (account instanceof Facebook) {
                outputArea.append(user1 + " y " + user2 + " ahora son amigos en Facebook\n");
            } else {
                outputArea.append(user1 + " ahora sigue a " + user2 + " en Twitter\n");
            }
            user1Field.setText("");
            user2Field.setText("");
        });
        
        // Acción para agregar comentario
        addCommentBtn.addActionListener(e -> {
            String user = userCommentField.getText().trim();
            String postIdText = postIdField.getText().trim();
            String author = authorField.getText().trim();
            String comment = commentField.getText().trim();
            
            if (user.isEmpty() || postIdText.isEmpty() || author.isEmpty() || comment.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            
            try {
                int postId = Integer.parseInt(postIdText);
                socialSystem.agregarComment(user, postId, author, comment);
                outputArea.append("Comentario agregado al post " + postId + " de " + user + "\n");
                userCommentField.setText("");
                postIdField.setText("");
                authorField.setText("");
                commentField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID del post debe ser un número");
            }
        });
        
        // Acción para ver perfil (este no necesita cambios porque profileFrom retorna String)
        viewProfileBtn.addActionListener(e -> {
            String user = profileField.getText().trim();
            if (user.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de usuario");
                return;
            }
            
            socialSystem.profileFrom(user);
        });
        
        setVisible(true);
    }
}