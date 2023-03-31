/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author golden
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class View {
    private JFrame frame;
    private JPanel panel;
    private ImageIcon smallImage;

    public View() {
        frame = new JFrame("App con Java Swing MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de la X en el centro del panel
                g.drawImage(new ImageIcon("C:\\Users\\golden\\Downloads\\src\\imagenes\\freezer.jpg").getImage(), getWidth() / 2 - 16, getHeight() / 2 - 16, null);

                // Dibujar la imagen pequeña en posiciones aleatorias
                Random random = new Random();
                for (int i = 0; i < 8000000; i++) {
                    int x = random.nextInt(getWidth() - smallImage.getIconWidth());
                    int y = random.nextInt(getHeight() - smallImage.getIconHeight());
                    g.drawImage(smallImage.getImage(), x, y, null);
                }
            }
        };

        // Cargar la imagen pequeña
        smallImage = new ImageIcon("C:\\Users\\golden\\Downloads\\src\\imagenes\\goku.jpg");

        frame.add(panel);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}

