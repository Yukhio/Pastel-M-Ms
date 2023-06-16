import java.util.Arrays;
class PastelMMs {
    public static int maxEqualParts(String mmsSequence) {
        int maxParts = 1; // Inicializar el número máximo de partes a 1 sin dejar restos

        for (int length = 1; length <= mmsSequence.length()/2; length++) {//Comenzamos el ciclo for para iterar las posibles longitudes 
            if (mmsSequence.length() % length == 0) {//Condición para saber si no es un divisor válido pasa a la siguiente longitud
                String subSequence = mmsSequence.substring(0, length);//Si la longitud actual es un divisor válido de la longitud total se toma
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
    private static void printReparto(String secuenciamms, int parts) {
        int partLength = secuenciamms.length() / parts;

        for (int i = 0; i < parts; i++) {
            String part = secuenciamms.substring(i * partLength, (i + 1) * partLength);
            System.out.print(" "+part);
        }
    }
    public static void main(String[] args) {
        String mmsSequence = "abcabcabcabc";//Se define la cadena no vacía
        int maxParts = maxEqualParts(mmsSequence);
        System.out.println("Número máximo de partes iguales: " + maxParts);
        printReparto(mmsSequence, maxParts);
    }
}
