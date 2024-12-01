import javax.swing.*;
import java.util.ArrayList;

public class GestionarLiga {
    private ArrayList<Heroe> heroes;

    public GestionarLiga() {
        this.heroes = new ArrayList<>();
    }

    public void registrarHeroe(Heroe heroe, JTextArea textArea) {
        heroes.add(heroe);
        textArea.setText("Héroe registrado con éxito: " + heroe.nombre);
    }

    public boolean eliminarHeroe(int id, JTextArea textArea) {
        for (Heroe heroe : heroes) {
            if (heroe.id == id) {
                heroes.remove(heroe);
                textArea.setText("Héroe eliminado con éxito: " + heroe.nombre);
                return true;
            }
        }
        textArea.setText("Héroe con ID " + id + " no encontrado.");
        return false;
    }

    public boolean buscarHeroe(int id) {

        boolean flag = false;

        for (Heroe heroe : heroes) {

            if (heroe.id == id) {

                flag = true;
            }
        }

        return flag;
    }

    public void modificarHeroe(int id, Heroe nuevosDatos, JTextArea textArea) {

        for (Heroe heroe : heroes) {

            if (heroe.id == id) {
                heroe.nombre = nuevosDatos.nombre;
                heroe.superpoder = nuevosDatos.superpoder;
                heroe.mision = nuevosDatos.mision;
                heroe.nivelDificultad = nuevosDatos.nivelDificultad;
                heroe.pagoMensual = nuevosDatos.pagoMensual;
                textArea.setText("Datos del héroe modificados con éxito.");
                break;

            }else{

                textArea.setText("Héroe con ID " + id + " no encontrado.");
            }
        }

    }


    public void mostrarHeroes(JTextArea textArea) {
        if (heroes.isEmpty()) {
            textArea.setText("No hay héroes registrados.");
            return;
        }

        StringBuilder listaHeroes = new StringBuilder("Lista de Héroes:\n");
        for (Heroe heroe : heroes) {
            listaHeroes.append("ID: ").append(heroe.id).append(", Nombre: ").append(heroe.nombre).append("\n");
        }
        textArea.setText(listaHeroes.toString());
    }

    public void calcularInforme(JTextArea textArea) {
        if (heroes.isEmpty()) {
            textArea.setText("No hay héroes registrados para generar un informe.");
            return;
        }

        StringBuilder informe = new StringBuilder("Informe de Héroes:\n");
        for (Heroe heroe : heroes) {
            informe.append("Nombre: ").append(heroe.nombre).append("\n")
                    .append("Superpoder: ").append(heroe.superpoder).append("\n")
                    .append("Pago Mensual: $").append(heroe.pagoMensual).append("\n")
                    .append("Aporte al Fondo: $").append(heroe.calcularAporte()).append("\n")
                    .append("Impuesto: $").append(heroe.calcularImpuesto()).append("\n")
                    .append("Pago Neto: $").append(heroe.obtenerPagoNeto()).append("\n\n");
        }
        textArea.setText(informe.toString());
    }
}
