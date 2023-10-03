import java.util.ArrayList;
import java.util.Scanner;

public class CalculoEstadisticas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opc = "";
        int numeros=0;
        Formulas formulas = new Formulas();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        while (!opc.equals("0")) {
            System.out.println("Menu Principal\n1 - Introducir Datos\n2 - Media\n3 - Varianza\n4 - Desviación\n0- Salir");
            System.out.print("Ingrese una opcion: ");
            opc = sc.nextLine();
            switch (opc) {
                case "1":
                    do{
                        numeros=1;
                        System.out.print("Escribe las alturas en cm: ");
                        System.out.print("Añade el valor de la altura en cm: ");
                        lista.add(sc.nextInt());
                        System.out.print("Para seguir introduciendo datos pulsa 1 y para salir cualquier otro numero: ");
                        numeros=sc.nextInt();
                        if(numeros!=1){
                            sc.nextLine();
                            numeros=0;
                        }else{
                            sc.nextLine();
                            numeros=1;
                        }
                    }while(numeros==1);
                    break;
                case "2":
                    System.out.println("La media es de: " + formulas.Media(lista));
                    break;
                case "3":
                    System.out.println("La varianza es de: " + formulas.Varianza(lista));
                    break;
                case "4":
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
        sc.close();
    }
}
