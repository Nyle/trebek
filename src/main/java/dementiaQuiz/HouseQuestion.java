package dementiaQuiz;

/**
 * Asks for the house number of the Echo owner
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class HouseQuestion extends Question {
    //~ Fields ............................................
    String correctAnswer;

    //~ Constructor .......................................
    public HouseQuestion(){
        correctAnswer = "101"
    }

    //~ Methods ...........................................
    public String getText(long seed){
        text = "What is your house or appartment number excluding any letters?";
        return text;
    }

    public String getReprompt(long seed){
        return this.getText(seed);
    }

    public boolean evaluateAnswer(long seed, String answer){
        if (correctAnswer.equals(answer)) {
            return true;
        }
        else {
            return false;
        }
    }
}