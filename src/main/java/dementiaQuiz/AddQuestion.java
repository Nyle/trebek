package trebek.dementiaquiz;

import trebek.Question;
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


        //~ Methods ...........................................
        private int getAdd1(long seed) {
                return add1 = (int)(seed % 701) % 10 + 3;
        }

        private int getAdd2(long seed) {
                return add2 = (int)(seed % 305) % 10 + 3;
        }

        public String getText(long seed){
                text = "What do you get when you add " + Integer.toString(this.getAdd1(seed)) + " and " + Integer.toString(this.getAdd2(seed)) + "?";
                return text;
        }

        public String getReprompt(long seed){
                return this.getText(seed);
        }

        public boolean evaluateAnswer(long seed, String[] answer){
                int intAnswer = this.getAdd1(seed) + this.getAdd2(seed);
                String correctAnswer = Integer.toString(intAnswer);
                if (correctAnswer.equals(answer)) {
                        return true;
                }
                else {
                        return false;
                }
        }
}
