package trebek.dementiaquiz;

import trebek.Question;
/**
 * Assigns a simple multiplication question
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class MultQuestion extends Question {
        //~ Fields ............................................
        private int multi1;
        private int multi2;

        //~ Constructor .......................................


        //~ Methods ...........................................
        private int getMulti1(long seed) {
                return multi1 = Math.abs((int)(seed % 701) % 10 + 3);
        }

        private int getMulti2(long seed) {
                return multi2 = Math.abs((int)(seed % 305) % 10 + 3);
        }

        public String getText(long seed){
                text = "What do you get when you multiply " + Integer.toString(this.getMulti1(seed)) + " and " + Integer.toString(this.getMulti2(seed)) + "?";
                return text;
        }

        public String getReprompt(long seed){
                return this.getText(seed);
        }

        public boolean evaluateAnswer(long seed, String[] answer){
                int correct = this.getMulti1(seed) * this.getMulti2(seed);
                int actualAnswer = Integer.parseInt(answer[0]);
                if (correct == actualAnswer) {
                        return true;
                }
                else {
                        return false;
                }
        }
}
