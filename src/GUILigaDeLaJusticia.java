import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILigaDeLaJusticia {
    private JPanel pGeneral;
    private JTabbedPane tabbedPane1;
    private JTextField id;
    private JButton registrarButton;
    private JButton limpiarButton;
    private JTextField nombre;
    private JTextField mision;
    private JTextField nivelDificultad;
    private JTextField pagoMensual;
    private JPanel PGeneral;
    private JTextField superPoder;
    private JTextArea registroNot;
    private JTextField idBuscar;
    private JButton modificarButton;
    private JTextField modSuperPoder;
    private JTextField modMision;
    private JTextField modNivelDificultad;
    private JTextField modPagoMensual;
    private JButton buscarButton;
    private JTextField modNombre;
    private JTextArea mostrarInfoMod;
    private JTextArea textArea1;
    private JButton listarButton;
    private JTextArea areaAporte;
    private JButton calcularAporteButton;
    private GestionarLiga gestionarLiga = new GestionarLiga();
    private Heroe heroe;


    public GUILigaDeLaJusticia() {

        modNombre.setEnabled(false);
        modSuperPoder.setEnabled(false);
        modMision.setEnabled(false);
        modNivelDificultad.setEnabled(false);
        modPagoMensual.setEnabled(false);
        modificarButton.setEnabled(false);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                heroe = new Heroe(Integer.parseInt(id.getText()), nombre.getText(), superPoder.getText(), mision.getText(), nivelDificultad.getText(), Double.parseDouble(pagoMensual.getText()));

                gestionarLiga.registrarHeroe(heroe, registroNot);
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                id.setText("");
                nombre.setText("");
                superPoder.setText("");
                mision.setText("");
                nivelDificultad.setText("");
                pagoMensual.setText("");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(gestionarLiga.buscarHeroe(Integer.parseInt(idBuscar.getText()))) {

                    modNombre.setEnabled(true);
                    modSuperPoder.setEnabled(true);
                    modMision.setEnabled(true);
                    modNivelDificultad.setEnabled(true);
                    modPagoMensual.setEnabled(true);
                    modificarButton.setEnabled(true);


                    JOptionPane.showMessageDialog(null, "Busqueda exitosa");
                }else{

                    modNombre.setEnabled(false);
                    modSuperPoder.setEnabled(false);
                    modMision.setEnabled(false);
                    modNivelDificultad.setEnabled(false);
                    modPagoMensual.setEnabled(false);
                    modificarButton.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Heroe no encontrado");
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Heroe heroeMod = new Heroe(Integer.parseInt(idBuscar.getText()), modNombre.getText(), modSuperPoder.getText(), modMision.getText(), modNivelDificultad.getText(), Double.parseDouble(modPagoMensual.getText()));
                gestionarLiga.modificarHeroe(Integer.parseInt(idBuscar.getText()), heroeMod, mostrarInfoMod);
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gestionarLiga.mostrarHeroes(textArea1);
            }
        });

        calcularAporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gestionarLiga.calcularInforme(areaAporte);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUILigaDeLaJusticia");
        frame.setContentPane(new GUILigaDeLaJusticia().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
