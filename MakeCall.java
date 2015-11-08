import java.util.Map;
import java.util.HashMap;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.factory.CallFactory;

public class MakeCall {

    public static final String ACCOUNT_SID = "AC0b5455ab5953910c7ab2cfc5492c9c0d";
    public static final String AUTH_TOKEN = "bcb33238698a9c946b19408d0140b166";

    public static void main(String[] args) throws TwilioRestException {

        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        Account mainAccount = client.getAccount();
        CallFactory callFactory = mainAccount.getCallFactory();
        Map<String, String> callParams = new HashMap<String, String>();
        callParams.put("To", "7032327549"); // Replace with your phone number
        callParams.put("From", "(540) 798-8062"); // Replace with a Twilio number
        callParams.put("Url", "http://demo.twilio.com/welcome/voice/");
        // Make the call
        Call call = callFactory.create(callParams);
        // Print the call SID (a 32 digit hex like CA123..)
        System.out.println(call.getSid());
    }
}