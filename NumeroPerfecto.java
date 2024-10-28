import java.util.HashMap;
import java.util.Map;

public class NumeroPerfecto {

    //tabla de resultados
    private static Map<Integer, Integer> memoDivisores = new HashMap<>();

    // Función recursiva para calcular la suma de divisores propios de un número n
    private static int sumaDivisores(int n, int divisor) {
        //verifico tabla
        if (memoDivisores.containsKey(n)) {
            return memoDivisores.get(n);
        }

        if (divisor > n / 2) {
            return 0;
        }

        // Si divisor es un divisor propio de n, lo sumamos y seguimos con el siguiente recursivamente
        int suma = (n % divisor == 0 ? divisor : 0) + sumaDivisores(n, divisor + 1);

        //Guardamos el resultado en el memo para futuros usos
        memoDivisores.put(n, suma);
        return suma;
    }

    private static boolean esPerfecto(int n) {
        return sumaDivisores(n, 1) == n;
    }

    public static void main(String[] args) {
        int[] numerosParaProbar = new int[]{1,6,6,2,4,28,5};

        for (int num : numerosParaProbar) {
            System.out.println(num + (esPerfecto(num) ? " es un número perfecto." : " no es un número perfecto."));
        }
    }
}
