class Pila {

    private String[] datos;
    private int cima;
    private int capacidad;

    // Constructor
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new String[capacidad];
        this.cima = -1;
    }

    // push: agregar elemento a la pila
    public void push(String valor) {
        if (cima == capacidad - 1) {
            System.out.println("La pila está llena");
            return;
        }
        datos[++cima] = valor;
    }

    // pop: eliminar el último elemento
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return datos[cima--];
    }

    // peek: ver el elemento superior
    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return datos[cima];
    }

    // verificar si la pila está vacía
    public boolean isEmpty() {
        return cima == -1;
    }

    // mostrar contenido de la pila
    public void mostrar() {
        if (isEmpty()) {
            System.out.println("(Texto vacío)");
            return;
        }

        for (int i = 0; i <= cima; i++) {
            System.out.println(datos[i]);
        }
    }

    // limpiar pila
    public void clear() {
        cima = -1;
    }
}