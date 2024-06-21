package vn.edu.likelion.lession2.letter;

public class Letter {
    /**
     * @param string
     * @return string has letter twice
     */
    public static String printLetterTwice(String string){
        StringBuilder result = new StringBuilder();

        for (char ch: string.toCharArray()){
            result.append(ch + "" + ch);
        }

        return result.toString();
    }
}
