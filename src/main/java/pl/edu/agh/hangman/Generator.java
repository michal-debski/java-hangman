package pl.edu.agh.hangman;

public class Generator {


    public void underscoreGenerate(String s) {
        if (!s.isEmpty()) {
            int stringLength = s.length();
            for (int i = 0; i < stringLength; i++) {
                System.out.print("_");
            }
        }
    }

    public String replaceUnserscoreWithLetter(String s, Character character) {
        String replacedString = s.replaceAll("A-Za-z", "_");
        s = replacedString.replace("*", character.toString());
        return s;
    }

    public String letterGenerate(String s, Character character) {
        if (!s.isEmpty() && s.contains(String.valueOf(character))) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == character) {
                    s = s.replace(String.valueOf(character), "*");
                    s = replaceUnserscoreWithLetter(s, character);
                }
            }
            return s;
        }
        throw new RuntimeException("Word must have at least one letter");
    }

}
