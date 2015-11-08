package dementiaQuiz;

/**
 * A quiz that tests patients for signs of the onset of Dementia
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class DementiaQuiz extends Quiz {
    //~ Fields ............................................
    questions = [WordsQuestion, DateQuestion, AddQuestion, MultQuestion, HouseQuestion];
    title = "Dementia Test";
    intro = "Hi! Are you ready to start your test?";

    //~ Constructor .......................................
    public Quiz() {

    }

    //~ Methods ...........................................

}