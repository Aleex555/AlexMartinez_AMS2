import java.util.ArrayList;
import java.util.Scanner;

public class CalculoEstadisticas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opc = "";
        Formulas formulas = new Formulas();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(192);
        lista.add(180);
        lista.add(190);
        lista.add(189);
        lista.add(170);
        lista.add(167);
        lista.add(174);
        lista.add(175);
        lista.add(175);
        lista.add(169);
        lista.add(169);
        lista.add(185);
        lista.add(172);
        lista.add(170);
        lista.add(186);
        lista.add(168);
        lista.add(174);
        lista.add(170);

        while (!opc.equals("0")) {
            System.out.println("Menu Principal\n1 - Media\n2 - Varianza\n3 - Desviación\n0 - Salir");
            System.out.print("Ingrese una opcion: ");
            opc = sc.nextLine();
            switch (opc) {
                case "1":
                    System.out.println("La media es de: " + formulas.Media(lista));
                    break;
                case "2":
                    System.out.println("La varianza es de: " + formulas.Varianza(lista));
                    break;
                case "3":
                    System.out.println("La desviación es de: " + formulas.Desviacion(lista));
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
}
