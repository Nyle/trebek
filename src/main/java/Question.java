package trebek;
/**
 * This is a basic outline for question objects
 * 
 * @author Brandon Cobbs
 * @version 11.07.2015
 */
public abstract class Question {

        protected String answer;
        protected String text;
	
	public abstract String getText(long seed);

	public abstract String getReprompt(long seed);
	
	public abstract boolean evaluateAnswer (long seed, String[] answers);
}
