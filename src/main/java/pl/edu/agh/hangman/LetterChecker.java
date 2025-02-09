package pl.edu.agh.hangman;

public class LetterChecker {

    public static boolean isLetterInWord(String word, char letter) {
        if (word != null || !word.isEmpty()) {
            if (word.contains(String.valueOf(letter))) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isWordCompleted() {

        return false;
    }
}
