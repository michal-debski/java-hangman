package pl.edu.agh.hangman;

public class Generator {
//    public static void main(String[] args) {
//        Generator g = new Generator();
//        System.out.println(g.letterReplace("abc", 'a'));
////        System.out.println(g.letterReplace("abc", 'b'));
//    }

    public String underscoreGenerate(String s) {
        StringBuilder sb = new StringBuilder();
        if (!s.isEmpty()) {
            int stringLength = s.length();
            sb.append("_".repeat(stringLength));
        }
        System.out.println("\n");
    return sb.toString();
    }

    public String letterReplace(String s, String s2, Character character) {
        StringBuilder sb = new StringBuilder();

        String s1 = String.valueOf(character);
        if (!s2.isEmpty() && s2.contains(s1)) {
            for (int i = 0; i < s.length(); i++) {
                if (s2.charAt(i) == character) {
                    sb.append(s);
                    sb.setCharAt(i, character);
                }
            }
            return String.valueOf(sb);
        }
        throw new RuntimeException("Word must have at least one letter");
    }

}
