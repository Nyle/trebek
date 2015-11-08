package dementiaQuiz;
import java.util.Calendar;

/**
 * Asks for the year
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class DateQuestion extends Question {
    //~ Fields ............................................
    String correctAnswer;

    //~ Constructor .......................................
    public DateQuestion(){
        Calendar cal = new Calendar();
        int year = Calendar.get(YEAR);
        correctAnswer = year.toString();
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
        if (correctAnswer == answer) {
            return true;
        }

        else {
            return false;
        }
    }
}