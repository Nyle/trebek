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

    //~ Constructor .......................................
    public Quiz(){

    }

    //~ Methods ...........................................
    public String getIntro(){
        return intro;
    }

    public Question getQuestion(int n){
        return questions[n];
    }

    public String getTitle(){
        return title;
    }
}
