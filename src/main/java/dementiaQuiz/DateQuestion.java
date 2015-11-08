package trebek.dementiaquiz;
import java.util.GregorianCalendar;
import java.util.Calendar;

import trebek.Question;
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
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        correctAnswer = Integer.toString(year);
    }

    //~ Methods ...........................................
    public String getText(long seed){
        text = "What is your house or appartment number excluding any letters?";
        return text;
    }

    public String getReprompt(long seed){
        return this.getText(seed);
    }

    public boolean evaluateAnswer(long seed, String[] answer){
        if (correctAnswer.equals(answer)) {
            return true;
        }
        else {
            return false;
        }
    }
}
