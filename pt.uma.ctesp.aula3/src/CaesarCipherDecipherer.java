public class CaesarCipherDecipherer {
    public static char[] cipher(char[] array, int index) {
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = CharacterUtilities.lowerLetterSuccessorStepsOf(array[i], index);
        }
        return result;
    }

    public static char[] decipher(char[] array,int index) {
        char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = CharacterUtilities.lowerLetterPredecessorStepsOf(array[i], index);
        }
        return result;
    }
}
