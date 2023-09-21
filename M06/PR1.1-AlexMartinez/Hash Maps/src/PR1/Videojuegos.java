package PR1;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Videojuegos {
    TreeMap llista = new TreeMap();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        String juego = "";
        Float precio;
        Videojuegos v1 = new Videojuegos();
        v1.llista.put("Starfield", 69.99f);
        v1.llista.put("Rust", 39.99f);
        v1.llista.put("Fifa24", 79.99f);
        v1.llista.put("Dying Light 2", 15.99f);
        v1.llista.put("Project Zomboid", 10.0f);

        while (!opcion.equals("0")) {
            System.out.println(
                    "Menu Principal\n1 - Añadir Juego\n2 - Modificar Precio\n3 - Eliminar Juego\n4 - Mostrar Juegos\n0 - Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Escribe el nombre del juego: ");
                    juego = sc.nextLine();
                    if (juego.isEmpty()) {
                        System.out.println("El nombre esta vacio.\n");
                        break;
                    }
                    System.out.print("Escribe el precio nuevo: ");
                    String input = sc.nextLine().trim();

                    if (input.isEmpty()) {
                        // Si la entrada está en blanco, establecer un valor predeterminado (por
                        // ejemplo, -1)
                        precio = -1f;
                        System.out.println("El precio está en blanco o es no válido.\n");
                    } else {
                        try {
                            precio = Float.parseFloat(input);
                            if (precio <= 0) {
                                System.out.println("El precio está en blanco o es no válido.\n");
                            } else {
                                v1.insertarJuegos(juego, precio);
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada no válida. Debes ingresar un valor numérico válido.\n");
                        } catch (NumberFormatException e) {
                            System.out.println("No se puede poner letras.\n");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Escribe el nombre del juego: ");
                    juego = sc.nextLine();
                    if (!juego.isEmpty()) {
                        v1.modificarPrecio(juego);
                    }
                    break;
                case "3":
                    System.out.print("Escribe el nombre del juego: ");
                    juego = sc.nextLine();
                    if (!juego.isEmpty()) {
                        v1.eliminarJuego(juego);
                    }
                    break;
                case "4":
                    System.out.println();
                    v1.mostrarAgenda();
                    break;
                case "0":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.\n");
                    break;
            }
        }

    }

    public void insertarJuegos(String juego, float precio) {
        if (llista.containsKey(juego)) {
            System.out.println("\nEl juego ya existe\n");
        } else {
            llista.put(juego, precio);
            System.out.println("El juego se ha introducido correctamente.\n");
        }

    }

    public void mostrarAgenda() {
        Set set = llista.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            System.out.println("Nombre: " + mapEntry.getKey() + ", " + "Precio: " + mapEntry.getValue());
            System.out.println();
        }
    }

    public void modificarPrecio(String juego) {
        Scanner sc = new Scanner(System.in);
        Float precio;
        if (!llista.containsKey(juego)) {
            System.out.println("\nEl juego no existe\n");
        } else {
            System.out.print("Escribe el precio nuevo: ");
            String input = sc.nextLine().trim(); // Leer la línea completa y eliminar espacios en blanco alrededor

            if (input.isEmpty()) {
                // Si la entrada está en blanco, establecer un valor predeterminado (por
                // ejemplo, -1)
                precio = -1f;
                System.out.println("El precio está en blanco o es no válido.\n");
            } else {
                try {
                    precio = Float.parseFloat(input);
                    if (precio <= 0) {
                        System.out.println("El precio está en blanco o es no válido.\n");
                    } else {
                        System.out.println();
                        llista.replace(juego, llista.get(juego), precio);
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada no válida. Debes ingresar un valor numérico válido.\n");
                } catch (NumberFormatException e) {
                    System.out.println("No se puede poner letras.\n");
                }
            }
        }

    }

    public void eliminarJuego(String juego) {
        if (llista.containsKey(juego)) {
            System.out.print("\nEstas seguro que quieres eliminarlo?: ");
            Scanner sc = new Scanner(System.in);
            String opc = sc.nextLine().toLowerCase();
            if (opc.equals("si")) {
                llista.remove(juego);
                System.out.println("El juego ha sido eliminado.\n");
            } else {
                System.out.println("El juego no ha sido eliminado.\n");
            }

        }
    }

}
