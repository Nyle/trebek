package trebek;

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
        public SpeechletResponse getLaunchResponse(LaunchRequest request,
                                                   Session session) {
                return getAskSpeechletResponse(
                        "Some Text", "");
        }
        public SpeechletResponse getHelpIntentResponse(Intent intent,
                                                       Session session) {
                return getTellSpeechletResponse("Help Text");
        }

        private SpeechletResponse getAskSpeechletResponse(String speechText,
                                                          String repromptText) {
                PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
                speech.setText(speechText);

                PlainTextOutputSpeech repromptSpeech =
                        new PlainTextOutputSpeech();
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
