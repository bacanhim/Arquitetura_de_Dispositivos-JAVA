import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

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
            if (a == '{') {
                a = 'a';
            }
        }
        return a;
    }

    public static char lowerLetterPredecessorStepsOf(char a, int val) {
        for (int i = 0; i < val; i++) {
            a--;
            if (a == '`') {
                a = 'z';
            }
        }
        return a;
    }

    public static int
    occurrencesOfCharacterIn(char[] array, char letter) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == letter) {
                num++;
            }
        }
        return num;
    }

    static char[] replaceCharacterIn(char letra, char[] array, char letra2) {
        for (int i = 0; i < array.length; i++) {
            if (letra == array[i]) {
                array[i] = letra2;
            }
        }
        return array;
    }

    public static char[] concatenationOf(char[] a1, char[] a2) {
        char[] res = new char[a1.length + a2.length];
        int i;
        for (i = 0; i < a1.length; i++) {
            res[i] = a1[i];
        }
        for (int l = 0; l < a2.length; l++) {
            res[i + l] = a2[l];
        }
        return res;
    }

    public static String toString(char[] a) {
        int i;
        String frase = "[";
        for (i = 0; i < a.length - 1; i++) {
            frase += a[i] + ",";
        }
        frase += a[i];
        frase += "]";
        return frase;
    }

    public static char[] copyOfPartOf(int index1, int index2, char[] array) {
        char[] newarray = new char[index2-index1+1];
        int count = 0;
        for (int i = index1; i <= index2; i++) {
            newarray[count] = array[i];
            count++;
        }
        return newarray;
    }
}