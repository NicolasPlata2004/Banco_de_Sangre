package Clases;

class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public void agregar(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
    }

    public Nodo<T> obtenerCabeza() {
        return cabeza;
    }

    public void eliminar(T valor) {
        if (cabeza == null) {
            return; // La lista está vacía, no hay nada que eliminar.
        }

        if (cabeza.valor.equals(valor)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null; // La lista ahora está vacía.
            }
            return;
        }

        Nodo<T> anterior = cabeza;
        Nodo<T> actual = cabeza.siguiente;

        while (actual != null && !actual.valor.equals(valor)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            anterior.siguiente = actual.siguiente;
            if (anterior.siguiente == null) {
                cola = anterior; // Actualizamos la cola si eliminamos el último elemento.
            }
        }
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
class Nodo<T> {
    T valor;
    Nodo<T> siguiente;

    Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
