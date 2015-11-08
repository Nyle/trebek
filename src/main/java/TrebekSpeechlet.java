package trebek;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class TrebekSpeechlet implements Speechlet {
	private static final Logger log = LoggerFactory
                .getLogger(TrebekSpeechlet.class);
	private ResponseManager responseManager;

	@Override
	public void onSessionStarted(final SessionStartedRequest request,
                                     final Session session)
                throws SpeechletException {
		log.info("onSessionStarted requestId={}, sessionId={}",
                         request.getRequestId(), session.getSessionId());
                initializeComponents();
	}

	@Override
	public SpeechletResponse onLaunch(final LaunchRequest request,
                                          final Session session)
                throws SpeechletException {
		log.info("onLaunch requestId={}, sessionId={}",
                         request.getRequestId(), session.getSessionId());
		return responseManager.getLaunchResponse(request, session);
	}

	@Override
	public SpeechletResponse onIntent(IntentRequest request,
                                          Session session)
                throws SpeechletException {
		log.info("onIntent requestId={}, sessionId={}",
                         request.getRequestId(),
                         session.getSessionId());
		Intent intent = request.getIntent();
                // add code to actually delegate to the right handlers
                return responseManager.getHelpIntentResponse(intent, session);
	}

	@Override
	public void onSessionEnded(final SessionEndedRequest request,
                                   final Session session)
                throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}",
                         request.getRequestId(), session.getSessionId());
	}

        private void initializeComponents() {
                responseManager = new ResponseManager();
        }
}
