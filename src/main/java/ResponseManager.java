package trebek;

import trebek.result.ResultManager;
import trebek.result.Result;

import trebek.dementiaquiz.DementiaQuiz;

import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.List;
import java.util.ArrayList;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class ResponseManager {
        private ResultManager resultManager;
        private Result result;
        private Quiz quiz;
        
        public ResponseManager(final AmazonDynamoDBClient client) {
                resultManager = new ResultManager(client);
                quiz = new DementiaQuiz();
        }

	public SpeechletResponse getLaunchResponse(LaunchRequest request, Session session) {
		this.loadResponse(session);
                SpeechletResponse res = getAskSpeechletResponse(quiz.getIntro(result.getSeed()) + ". " + quiz.getQuestion(0).getText(result.getSeed()), quiz.getQuestion(0).getReprompt(result.getSeed()));
                result.incrementQuestion();
                this.saveResponse();
		return res;
	}

	public SpeechletResponse getHelpIntentResponse(Intent intent, Session session) {
                this.loadResponse(session);
                this.saveResponse();
                return getTellSpeechletResponse("Help Text");
	}

	public SpeechletResponse getStartQuizIntentResponse(Intent intent, Session session) {
		this.loadResponse(session);
                result.setQuestion(0);
                result.setResults(new ArrayList<Boolean>());
                SpeechletResponse res = getAskSpeechletResponse(quiz.getIntro(result.getSeed()) + ". " + quiz.getQuestion(0).getText(result.getSeed()), quiz.getQuestion(0).getReprompt(result.getSeed()));
                result.incrementQuestion();
                this.saveResponse();
		return res;
        }

	public SpeechletResponse getNumberAnswerIntentResponse(Intent intent, Session session) {
                SpeechletResponse res;

		this.loadResponse(session);
                String[] ans = {intent.getSlot("NumberAnswer").getValue()};
                List<Boolean> answers = result.getResults();
                boolean eval = quiz.getQuestion(result.getQuestion()).evaluateAnswer(result.getSeed(), ans);
                System.out.println(new Boolean(eval));
                
                answers.add(eval);
                result.incrementQuestion();
                Question next = quiz.getQuestion(result.getQuestion());
                if (next == null) {
                        res = getTellSpeechletResponse(quiz.getOutro(result.getSeed()));
                        result.setIsDone(Boolean.TRUE);
                } else {
                        res = getAskSpeechletResponse(next.getText(result.getSeed()), next.getReprompt(result.getSeed()));
                }
                this.saveResponse();
                return res;
	}

	public SpeechletResponse getStringAnswerIntentResponse(Intent intent, Session session) {

                SpeechletResponse res;

		this.loadResponse(session);
                String[] ans = {intent.getSlot("StringAnswerOne").getValue(),
                                intent.getSlot("StringAnswerTwo").getValue(),
                                intent.getSlot("StringAnswerThree").getValue()};
                List<Boolean> answers = result.getResults();
                answers.add(quiz.getQuestion(result.getQuestion())
                            .evaluateAnswer(result.getSeed(), ans));
                result.incrementQuestion();
                Question next = quiz.getQuestion(result.getQuestion());
                if (next == null) {
                        res = getTellSpeechletResponse(quiz.getOutro(result.getSeed()));
                        result.setIsDone(Boolean.TRUE);
                } else {
                        res = getAskSpeechletResponse(next.getText(result.getSeed()), next.getReprompt(result.getSeed()));
                }
                this.saveResponse();
                return res;
	}

	private SpeechletResponse getAskSpeechletResponse(String speechText, String repromptText) {
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
		repromptSpeech.setText(repromptText);
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(repromptSpeech);

		return SpeechletResponse.newAskResponse(speech, reprompt);
	}

	private SpeechletResponse getTellSpeechletResponse(String speechText) {
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(speechText);

		return SpeechletResponse.newTellResponse(speech);
	}

        private void loadResponse(Session session) {
                result = resultManager.loadCurrentResult(session.getUser().getUserId());
        }

        private void saveResponse() {
                resultManager.save(result);
        }
}
