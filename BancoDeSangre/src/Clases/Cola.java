package Clases;


class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> finalCola;

    // Constructor para inicializar la cola vacía
    public Cola() {
        this.frente = null;
        this.finalCola = null;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Método para encolar un elemento
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
    }

    public T desencolar() {
        if (estaVacia()) {
            return null; // La cola está vacía
        }

        T elementoDesencolado = frente.valor;
        frente = frente.siguiente;

        if (frente == null) {
            finalCola = null;
        }

        return elementoDesencolado;
    }

    // Clase interna para representar los nodos de la cola
    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }
}