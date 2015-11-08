package dementiaQuiz;

/**
 * Assigns a simple addition question
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class AddQuestion extends Question {
    //~ Fields ............................................
    private int add1;
    private int add2;

    //~ Constructor .......................................
    public AddQuestion(){

    }

    //~ Methods ...........................................
    private int getAdd1(long seed) {
        add1 = seed % 701 % 10 + 3;
    }

    private int getAdd2(long seed) {
        add2 = seed % 305 % 10 + 3;
    }

    public String getText(long seed){
        text = "What do you get when you add " + this.getAdd1(seed).toString() + " and " + this.getAdd2(seed).toString() "?";
        return text;
    }

    public String getReprompt(long seed){
        return this.getText(seed);
    }

    public boolean evaluateAnswer(long seed, String answer){
        int intAnswer = this.getAdd1(seed) + this.getAdd2(seed);
        String correctAnswer = intAnswer.toString();
        if (correctAnswer == answer) {
            return true;
        }

        else {
            return false;
        }
    }
}