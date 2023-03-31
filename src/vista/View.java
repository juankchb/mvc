import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class View {
    private JFrame frame;
    private JPanel panel;
    private ImageFactory imageFactory;

    public View() {
        frame = new JFrame("App con Java Swing MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Dibujar la imagen de la X en el centro del panel
                Image xImage = imageFactory.getImage("C:\\Users\\golden\\Downloads\\src\\imagenes\\freezer.jpg");
                g.drawImage(xImage, getWidth() / 2 - 16, getHeight() / 2 - 16, null);

                // Dibujar la imagen pequeña en posiciones aleatorias
                Random random = new Random();
                for (int i = 0; i < 800000; i++) {
                    int x = random.nextInt(getWidth() - 16);
                    int y = random.nextInt(getHeight() - 16);
                    Image smallImage = imageFactory.getImage("C:\\Users\\golden\\Downloads\\src\\imagenes\\\\goku.jpg");
                    g.drawImage(smallImage, x, y, null);
                }
            }
        };

        imageFactory = new ImageFactory();

        frame.add(panel);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}
/**
 * La clase ImageFactory utiliza un Map para almacenar las imágenes, con la clave siendo el nombre del archivo de la imagen. Cuando se solicita una imagen, la clase ImageFactory verifica si la imagen ya se ha cargado en el Map. Si es así, devuelve la imagen almacenada en el Map. De lo contrario, carga la imagen desde el archivo, la almacena en el Map y la devuelve.
 */
class ImageFactory {
    private Map<String, Image> imageMap;

    public ImageFactory() {
        imageMap = new HashMap<>();
    }

    public Image getImage(String name) {
        Image image = imageMap.get(name);
        if (image == null) {
            image = loadImage(name);
            imageMap.put(name, image);
        }
        return image;
    }

    private Image loadImage(String name) {
        ImageIcon icon = new ImageIcon(name);
        return icon.getImage();
    }
}

