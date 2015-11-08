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
        int correct;

        //~ Constructor .......................................
        public DateQuestion(){
                Calendar cal = new GregorianCalendar();
                correct = cal.get(Calendar.YEAR);
        }

        //~ Methods ...........................................
        public String getText(long seed){
                text = "What is the current year?";
                return text;
        }

        public String getReprompt(long seed){
                return this.getText(seed);
        }

        public boolean evaluateAnswer(long seed, String[] answer){
                if (Integer.parseInt(answer[0]) == correct) {
                        return true;
                }
                else {
                        return false;
                }
        }
}
