public class Ficha3 {

    public static void main(String[] args) {
        System.out.println(CharacterUtilities.lowerLetterSuccessorOf('z'));
        System.out.println(CharacterUtilities.lowerLetterPredecessorOf('b'));
        System.out.println(CharacterUtilities.lowerLetterSuccessorStepsOf('g', 1));
        System.out.println(CharacterUtilities.lowerLetterPredecessorStepsOf('v', 1));
        System.out.println(CharacterUtilities.occurrencesOfCharacterIn(new char[]{'a', 'a'}, 'a'));
        System.out.println(CharacterUtilities.replaceCharacterIn('a',new char[]{'a','a'},'d'));
    }
}
