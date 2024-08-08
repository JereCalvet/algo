public class Potencias {
    public static void main(String[] args) {
        System.out.println("potencia i " + potenciaIterativa(3,3));
        System.out.println("potencia r " + potenciaRecursiva(3,3));
    }

    static int potenciaIterativa(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (a == 0) {
            return 0;
        }

        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    static int potenciaRecursiva(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (a == 0) {
            return 0;
        }
        return a * potenciaRecursiva(a, b-1);
    }
}
