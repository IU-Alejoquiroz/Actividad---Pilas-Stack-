import java.util.Scanner;

public class EditorTexto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pila undo = new Pila(100);
        Pila redo = new Pila(100);

        int opcion;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese texto: ");
                    String texto = sc.nextLine();

                    undo.push(texto);
                    redo.clear(); // nueva acción elimina redo

                    break;

                case 2:

                    if (!undo.isEmpty()) {
                        String accion = undo.pop();
                        redo.push(accion);
                        System.out.println("Acción deshecha");
                    } else {
                        System.out.println("Nada para deshacer");
                    }

                    break;

                case 3:

                    if (!redo.isEmpty()) {
                        String accion = redo.pop();
                        undo.push(accion);
                        System.out.println("Acción rehecha");
                    } else {
                        System.out.println("Nada para rehacer");
                    }

                    break;

                case 4:

                    System.out.println("\nTexto actual:");
                    undo.mostrar();

                    break;

                case 5:

                    System.out.println("Saliendo del programa...");

                    break;

                default:

                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        sc.close();
    }
}