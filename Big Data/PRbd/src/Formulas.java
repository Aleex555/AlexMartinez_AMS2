import java.util.ArrayList;

public class Formulas {
    int Suma(ArrayList<Integer> lista) {
        int suma = 0;
        for (int i : lista) {
            suma = suma + i;
        }
        return suma;
    }

    double Media(ArrayList<Integer> lista) {
        return Suma(lista) / lista.size();
    }

    double Varianza(ArrayList<Integer> lista) {
        double total = 0;
        for (int i : lista) {
            total = total + Math.pow(i - Media(lista), 2);
        }
        return total;
    }

    double Desviacion(ArrayList<Integer> lista) {
        return Math.sqrt(Varianza(lista));
    }
}
