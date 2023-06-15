import java.util.Arrays;

class CakeCutting {
    public static int maxEqualParts(String mmsSequence) {
        int maxParts = 1; // Inicializar el número máximo de partes a 1

        for (int length = 1; length <= mmsSequence.length()/maxParts; length++) {
            if (mmsSequence.length() % length == 0) {
                String subSequence = mmsSequence.substring(0, length);
                int possibleParts = mmsSequence.length() / length;

                if (isSequenceRepeated(mmsSequence, subSequence, possibleParts)) {
                    maxParts = possibleParts;
                }
            }
        }

        return maxParts;
    }

    //Método para construir una cadena repetida y comparar con la secuencia original
    private static boolean isSequenceRepeated(String mmsSequence, String subSequence, int possibleParts) {
        StringBuilder repeatedSequence = new StringBuilder(subSequence.length() * possibleParts);

        for (int i = 0; i < possibleParts; i++) {
            repeatedSequence.append(subSequence);
        }

        return repeatedSequence.toString().equals(mmsSequence);
    }

    //Método para mostrar la división de la cadena
    private static void printDividirPastel(String secuenciamms, int parts) {
        int partLength = secuenciamms.length() / parts;

        for (int i = 0; i < parts; i++) {
            String part = secuenciamms.substring(i * partLength, (i + 1) * partLength);
            System.out.print(" "+part);
        }
    }

    public static void main(String[] args) {
        String mmsSequence = "abcabcabcabc";
        int maxParts = maxEqualParts(mmsSequence);
        System.out.println("Número máximo de partes iguales: " + maxParts);
        printDividirPastel(mmsSequence, maxParts);
    }

}
