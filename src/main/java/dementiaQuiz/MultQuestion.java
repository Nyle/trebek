/**
 * Assigns a simple multiplication question
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class WordsQuestion extends Question {
    //~ Fields ............................................
    private int multi1;
    private int multi2;

    //~ Constructor .......................................


    //~ Methods ...........................................
    private int getMulti1(long seed) {
        multi1 = seed % 701 % 10 + 3;
    }

    private int getMulti2(long seed) {
        multi2 = seed % 305 % 10 + 3;
    }

    public String getText(long seed){
        text = "What do you get when you multiply " + this.getMulti1(seed).toString() + " and " + this.getMulti2(seed).toString() "?";
        return text;
    }

    public String getReprompt(long seed){
        return this.getText(seed);
    }

    public boolean evaluateAnswer(long seed, String answer){
        int intAnswer = this.getMulti1(seed) * this.getMulti2(seed);
        String correctAnswer = intAnswer.toString();
        if (correctAnswer.equals(answer)) {
            return true;
        }
        else {
            return false;
        }
    }
}