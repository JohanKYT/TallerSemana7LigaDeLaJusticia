public class Heroe {
    public int id;
    public String nombre;
    public String superpoder;
    public String mision;
    public String nivelDificultad;
    public double pagoMensual;

    public Heroe(int id, String nombre, String superpoder, String mision, String nivelDificultad, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.superpoder = superpoder;
        this.mision = mision;
        this.nivelDificultad = nivelDificultad;
        this.pagoMensual = pagoMensual;
    }

    public double calcularAporte() {
        return this.pagoMensual * 0.10;
    }

    public double calcularImpuesto() {
        double pagoAnual = this.pagoMensual * 12;
        if (pagoAnual <= 60000) {
            return 0;
        } else if (pagoAnual > 60000 && pagoAnual <= 120000) {
            return (pagoAnual - 60000) * 0.12;
        } else if (pagoAnual > 120000 && pagoAnual <= 240000) {
            return (pagoAnual - 120000) * 0.25 + 7200;
        } else {
            return (pagoAnual - 240000) * 0.35 + 37200;
        }
    }

    public double obtenerPagoNeto() {
        return (this.pagoMensual - (calcularAporte() - calcularImpuesto())) / 12;
    }
}
