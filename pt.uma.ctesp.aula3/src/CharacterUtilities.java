public class CharacterUtilities {
    public static char lowerLetterSuccessorOf(char a) {
        a++;
        if (a == '{') {
            a = 'a';
        }
        return a;
    }

    public static char lowerLetterPredecessorOf(char a) {
        a--;
        if (a == '`') {
            a = 'z';
        }
        return a;
    }

    public static char lowerLetterSuccessorStepsOf(char a, int val) {
        for (int i = 0; i < val; i++) {
            a++;
        }
        if (a == '{') {
            a = 'a';
        }
        return a;
    }

    public static char lowerLetterPredecessorStepsOf(char a, int val) {
        for (int i = 0; i < val; i++) {
            a--;
        }
        if (a == '`') {
            a = 'z';
        }
        return a;
    }

    public static int occurrencesOfCharacterIn(char[] array, char letter) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == letter) {
                num++;
            }
        }
        return num;
    }

    public static char[] replaceCharacterIn(char letra, char[] array, char letra2) {
        for (int i = 0; i < array.length; i++) {
            if (letra == array[i]) {
                array[i] = letra2;
            }
        }
        return array;
    }

    public static char[] concatenationOf(char[] array1, char[] array2) {
        char[] arrayfinal = new char[(array1.length + array2.length)];


        return arrayfinal;
    }
}