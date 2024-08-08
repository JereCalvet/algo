public class Diagonales {
    public static void main(String[] args) {
        int[][] matriz = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        imprimirMatriz(matriz);

        System.out.println("sum i: " + sumaDiagonalIterativa(matriz));
        System.out.println("sum r: " + sumaDiagonalRecursiva(matriz, matriz.length));

    }

    static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int sumaDiagonalIterativa(int[][] m) {
        int result = 0;
        for (int i = 0; i < m.length; i++) {
            result += m[i][i];
        };
        return result;
    }

    static int sumaDiagonalRecursiva(int[][] m, int l) {
        if (l == 0) {
            return 0;
        }
        return m[l-1][l-1] + sumaDiagonalRecursiva(m, l-1);
    }
}
