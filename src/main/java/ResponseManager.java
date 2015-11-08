package trebek;

import trebek.result.ResultManager;
import trebek.result.Result;

import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.List;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class ResponseManager {
        private ResultManager resultManager;
        
        public ResponseManager(final AmazonDynamoDBClient client) {
                resultManager = new ResultManager(client);
        }
	int i = 0;

	public SpeechletResponse getLaunchResponse(LaunchRequest request, Session session) {
		return getTellSpeechletResponse("some text");
	}

	public SpeechletResponse getHelpIntentResponse(Intent intent, Session session) {
		return getTellSpeechletResponse("Help Text");
	}

	public SpeechletResponse setStartQuizIntentResponse(Intent intent, Session session) {
		// add real things to start quiz
		return getAskSpeechletResponse("Okay, let's start. " + DementiaQuiz.wq.giveWords());
	}
	
	public SpeechletResponse setStartQuestionsIntentResponse(Intent intent, Session session) {
		if (i == 0) {
			i++;
			return getAskSpeechletResponse(DementiaQuiz.dq.getText());
		}
	}

	public SpeechletResponse setNumberAnswerIntentResponse(Intent intent, Session session) {
		// add real things to change number answer
		
		if (i == 1) {
			i++;
			return getAskSpeechletResponse(DementiaQuiz.aq.getText());
		}
		else if (i == 2) {
			i++;
			return getAskSpeechletResponse(DementiaQuiz.mq.getText());
		}
		else if (i == 3) {
			i++;
			return getAskSpeechletResponse(DementiaQuiz.hq.getText());
		}
		else if (i == 4) {
			i++;
			return getAskSpeechletResponse(DementiaQuiz.wq.getText());
		}

	}

	public SpeechletResponse setStringAnswerIntentResponse(Intent intent, Session session) {
		// add real things to change string answer
		return getTellSpeechletResponse("Thank you for your time!");
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
}
