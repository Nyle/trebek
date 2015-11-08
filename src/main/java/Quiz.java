package trebek;
/**
 * Gets the title, intro, and questions of a quiz
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class Quiz {
        //~ Fields ............................................
        protected Question[] questions;
        protected String title;
        protected String intro;
        protected String outro;

        //~ Constructor .......................................
        protected Quiz(){

        }

        protected void setQuestions(Question[] questions) {
                this.questions = questions;
        }

        //~ Methods ...........................................
        public String getIntro(long seed) {
                return intro;
        }

        public String getOutro(long seed){
                return outro;
        }

        public Question getQuestion(int n){
                System.out.println(n);
                return questions.length > n ? questions[n] : null;
        }

        public String getTitle(){
                return title;
        }
}
