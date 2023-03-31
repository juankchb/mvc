import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Vista extends JFrame {
    private JPanel panel = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Image image;
            try {
                image = ImageIO.read(getClass().getResource("x.png"));
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    };
    private JButton boton = new JButton("Convertir");
    private JTextField textoEntrada = new JTextField(20);
    private JTextField textoSalida = new JTextField(20);
 
    public Vista() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 
        panel.add(textoEntrada);
        panel.add(boton);
        panel.add(textoSalida);
 
        this.add(panel);
    }
 
    public String getTextoEntrada() {
        return textoEntrada.getText();
    }
 
    public void setTextoSalida(String texto) {
        textoSalida.setText(texto);
    }
 
    void addListener(ActionListener listenForButton) {
        boton.addActionListener(listenForButton);
    }
}
