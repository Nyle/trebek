package trebek;

import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class TrebekSpeechletRequestStreamHandler extends
		SpeechletRequestStreamHandler {
	private static final Set<String> supportedApplicationIds =
                new HashSet<String>();
	static {
		supportedApplicationIds.add(
                        "amzn1.echo-sdk-ams.app." +
                        "ed2d4d50-a3d0-42cd-98c2-be98bbab9ae6");
	}

	public TrebekSpeechletRequestStreamHandler() {
		super(new TrebekSpeechlet(), supportedApplicationIds);
	}
}
