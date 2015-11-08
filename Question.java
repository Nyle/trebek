public abstract class Question {

	
	public abstract String getText(unsigned long seed);

	public abstract String getRepromt(unsigned long seed);
	
	public abstract boolean evaluateAnswer (unsigned long seed, String answer);
}