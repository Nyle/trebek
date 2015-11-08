package dementiaQuiz;

/**
 * A quiz that tests patients for signs of the onset of Dementia
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */

public class DementiaQuiz extends Quiz {
    //~ Fields ............................................
    WordsQuestion wq = new WordsQuestion();
    DateQuestion dq = new DateQuestion();
    AddQuestion aq = new AddQuestion();
    MultQuestion mq = new MultQuestion();
    HouseQuestion hq = new HouseQuestion();
    questions = [wq, dq, aq, mq, hq];
    title = "Dementia Test";
    intro = "Hi! Are you ready to start your test?";

    //~ Constructor .......................................


    //~ Methods ...........................................

}