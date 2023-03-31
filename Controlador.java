import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.addListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String textoEntrada = vista.getTextoEntrada();
            modelo.setTexto(textoEntrada.toUpperCase());
            vista.setTextoSalida(modelo.getTexto());
        }
    }
}
