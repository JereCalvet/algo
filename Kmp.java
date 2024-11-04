public class Kmp {
    public static void main(String[] args) {
        System.out.println("TERFTERA esta en la posición: " + strStr("TEDTHRETETERTERFTERFTERFTERA", "TERFTERA"));
        System.out.println("ACIECIACIEN esta en la posición: " + strStr("AACCIIAACIACIEACIECIACIEN", "ACIECIACIEN"));
        System.out.println("KGRHRHKGH esta en la posición: " +strStr("KGRHKGRHRHKGKGRHRHKGH", "KGRHRHKGH"));
    }
    public static int strStr(String haystack, String needle) {
        // longest preffix suffix -> el prefijo-sufijo más largo
        int[] lps = new int[needle.length()];

        // el lps en la posición 0 debe ser 0 porque el primer carácter (cuando solo hay 1 carácter) no tendrá ni prefijo ni sufijo. Java ya lo hace por mí
        // lps[0] = 0

        // ciclo desde 1 porque empezamos a buscar el sufijo
        int i = 1;
        // longitud del lps
        int prevLps = 0;

        // lo que hacemos es mover un puntero a través del patrón mientras analizamos cada carácter
        while (i < needle.length()) {
            // coincidencia = incrementa la longitud del prefijo en la longitud anterior +1
            if (needle.charAt(prevLps) == needle.charAt(i)) {
                prevLps++;
                lps[i] = prevLps;
                i++;
                // no coincide = retrocedemos hasta que la longitud del prefijo anterior sea 0
            } else if (prevLps == 0) {
                lps[i] = 0;
                i++;
            } else {
                prevLps = lps[prevLps - 1];
            }
        }

        // ALGORITMO
        int hayStackIndex = 0, patterIndex = 0;
        while (hayStackIndex < haystack.length()) {
            // si coincide, avanzamos la ventana
            if (haystack.charAt(hayStackIndex) == needle.charAt(patterIndex)) {
                hayStackIndex++;
                patterIndex++;
                // si no coincide y el índice del patrón es 0, movemos el puntero de haystack
            } else if (patterIndex == 0) {
                hayStackIndex++;
                // si no coincide, establecemos el índice del patrón al valor lps anterior de haystack (retrocede 1 posición)
            } else {
                patterIndex = lps[patterIndex - 1];
            }
            // si el índice del patrón es igual a la longitud de needle significa que encontramos la última letra del patrón
            if (patterIndex == needle.length()) {
                return hayStackIndex - patterIndex;
            }
        }

        return -1;
    }
}
