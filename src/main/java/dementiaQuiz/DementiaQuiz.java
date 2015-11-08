package trebek.dementiaquiz;

import trebek.Quiz;
import trebek.Question;
/**
 * A quiz that tests patients for signs of the onset of Dementia
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class DementiaQuiz extends Quiz {
        DateQuestion dq = new DateQuestion();
        AddQuestion aq = new AddQuestion();
        MultQuestion mq = new MultQuestion();
        HouseQuestion hq = new HouseQuestion();
        WordsQuestion wq = new WordsQuestion();
                
        public DementiaQuiz() {
                Question[] questions = {dq, aq, mq, hq, wq};
                super.setQuestions(questions);
        }

        public String getIntro(long seed) {
                return "Let's get started " + wq.giveWords(seed);
        }

        public String getOutro(long seed) {
                return "Thanks for your time";
        }
}
