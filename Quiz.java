/**
 * Gets the title, intro, and questions of a quiz
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class Quiz {
    //~ Fields ............................................
    private Question[] questions;
    private String title;
    private String intro;

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