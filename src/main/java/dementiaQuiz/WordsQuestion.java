package dementiaQuiz;

/**
 * Assigns words to remember and calls for them at the end of the test
 *
 * @author Aarav Singh
 * @version (2015.11.07)
 */
import java.util.Random;

public class WordsQuestion extends Question {
    //~ Fields ............................................
    String[] wordArray = {"time", "year", "people", "man", "day", "thing", "child", "mister", "government", "work", "life", "woman", "system", "case", "part", "group", "number", "world", "house", "area", "company", "problem", "service", "place", "hand", "party", "school", "country", "point", "week", "member", "end", "state", "word", "family", "fact", "head", "month", "side", "business", "night", "eye", "home", "question", "information", "power", "change", "interest", "development", "money", "book", "water", "form", "room", "level", "car", "council", "policy", "market", "court", "effect", "result", "idea", "study", "job", "name", "body", "report", "line", "law", "face", "friend", "authority", "road", "minister", "door", "hour", "office", "right", "war", "mother", "person", "reason", "term", "period", "center", "figure", "society", "police", "city", "community", "million", "price", "controls", "action", "cost", "issue", "process", "position", "course", "minute", "education", "type", "research", "subject", "program", "girl", "moment", "age", "father", "force", "order", "value", "matter", "health", "decision", "street", "industry", "patient", "class", "mind", "church", "condition", "paper", "bank", "century", "section", "activity", "table", "building", "staff", "team", "experience", "student", "language", "town", "plan", "department", "management", "morning", "committee", "product", "evidence", "ground", "letter", "meeting", "foot", "boy", "back", "game", "food", "union", "role", "event", "land", "art", "support", "range", "stage", "teacher", "trade", "voice", "arm", "club", "field", "history", "parent", "account", "material", "care", "situation", "manager", "record", "example", "training", "window", "air", "difference", "light", "university", "wife", "relationship", "sir", "quality", "rule", "pound", "story", "tax", "worker", "data", "model", "nature", "officer", "structure", "bed", "hospital", "method", "unit", "movement", "detail", "date", "wall", "computer", "amount", "award", "president", "scheme", "chapter", "theory", "property", "son", "director", "leader", "south", "application", "firm", "board", "king", "production", "secretary", "chance", "operation", "opportunity", "agreement", "lord", "contract", "picture", "test", "security", "thousand", "election", "source", "color", "future", "site", "loss", "shop", "animal", "evening", "benefit", "heart", "purpose", "standard", "page", "doctor", "factor", "hair", "love", "music", "charge", "pattern", "design", "piece", "population", "tree", "knowledge", "performance", "plant", "pressure", "fire", "environment", "garden", "size", "analysis", "rest", "success", "thought", "region", "attention", "list", "relation", "set", "space", "statement", "demand", "labor", "principle", "sea", "step", "capital", "choice", "couple", "hotel", "movie", "station", "village", "film", "association", "attempt", "feature", "income", "individual", "cup", "effort", "organisation", "technology", "difficulty", "machine", "cell", "degree", "energy", "growth", "treatment", "lady", "mile", "county", "function", "provision", "risk", "sound", "task", "top", "behavior", "defense", "resource", "floor", "science", "style", "college", "feeling", "hall", "horse", "response", "skill", "character", "user", "answer", "army", "dog", "economy", "investment", "look", "brother", "husband", "argument", "responsibility", "season", "bill", "concern", "element", "glass", "duty", "increase", "claim", "fund", "leg", "park", "title", "note", "aspect", "chairman", "discussion", "summer", "baby", "daughter", "sun", "box", "customer", "institution", "river", "profit", "conference", "division", "measure", "stone", "commission", "post", "procedure", "proposal", "circumstance", "client", "help", "image", "oil", "sector", "attack", "direction", "seat", "attitude", "disease", "employment", "goal", "affair", "appeal", "sign", "ability", "campaign", "fish", "holiday", "item", "medium", "pupil", "show", "technique", "version", "advice", "library", "press", "visit", "advantage", "surface", "blood", "culture", "island", "memory", "return", "television", "variety", "bar", "competition", "extent", "majority", "parliament", "speaker", "talk", "access", "deal", "no", "star", "text", "cause", "mouth", "payment", "trouble", "context", "facility", "reference", "second", "survey", "article", "chair", "earth", "importance", "object", "agency", "card", "collection", "communication", "possibility", "public", "document", "sister", "supply", "budget", "career", "influence", "solution", "weight", "bird", "damage"};
    String word1;
    String word2;
    String word3;
    
    //~ Constructor .......................................
    public WordsQuestion() {
    	
    }

    //~ Methods ...........................................
    
    public String getText(long seed) {
    	
    	word1 = wordArray[calcIndexOne(seed)];
    	word2 = wordArray[calcIndexTwo(seed)];
    	word3 = wordArray[calcIndexThree(seed)];
    	
    	return "Your words are " + word1 + ", " + word2 ", " + word3;
    }
        
    public String getRepromt(long seed) {
        return getText(seed);
    }
    
    public boolean evaluateAnswer(long seed, String answer) {
        return getText(seed).equals(answer);
    }
    
    private int calcIndexOne(long seed) {
    	int index1 = (1664525 * seed + 1013904233)% Math.pow(2, 32) % 149;
    	return index1;
    }
    
    private int calcIndexTwo(long seed) {
    	int index2 = (22695477 * seed + 1) % Math.pow(2, 32) % 149 + 149;
    	return index2;
    }
    
    private int calcIndexThree(long seed) {
    	int index3 = (1103515245 * seed + 12345) % Math.pow(2, 31) % 149 + 149 * 2;
    	return index3;
    }
}