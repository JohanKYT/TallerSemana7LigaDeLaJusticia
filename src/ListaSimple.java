import javax.swing.*;

public class ListaSimple {
    public Nodo inicio;
    public int tam;

    public ListaSimple() {
        inicio = null;
        tam = 0;
    }

    public void agregar(int dato, JTextArea textArea) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tam++;
        mostrar(textArea);
    }

    public boolean eliminar(int dato, JTextArea textArea) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacía, no se puede eliminar.");
            return false;
        }

        if (inicio.dato == dato) {
            inicio = inicio.siguiente;
            tam--;
            mostrar(textArea);
            return true;
        }

        Nodo actual = inicio;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
            return false;
        }

        actual.siguiente = actual.siguiente.siguiente;
        tam--;
        mostrar(textArea);
        return true;
    }

    public int buscar(int dato) {
        Nodo actual = inicio;
        int pos = 0;
        while (actual != null) {
            if (actual.dato == dato) {
                return pos;
            }
            actual = actual.siguiente;
            pos++;
        }
        return -1;
    }

    public void mostrar(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("Lista vacía.");
            return;
        }

        StringBuilder listaStr = new StringBuilder("Lista: \n");
        Nodo actual = inicio;
        while (actual != null) {
            listaStr.append(actual.dato).append("\n");
            actual = actual.siguiente;
        }

        textArea.setText(listaStr.toString());
    }

    public void ordenar(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) {
            return;
        }

        boolean burb;
        do {
            burb = false;
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    int aux = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = aux;
                    burb = true;
                }
                actual = actual.siguiente;
            }
        } while (burb);
        mostrar(textArea);
    }
}
