import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 
public class SendText {
 
    // Find your Account SID and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC0b5455ab5953910c7ab2cfc5492c9c0d";
    public static final String AUTH_TOKEN = "bcb33238698a9c946b19408d0140b166"; 
 
    public static void main(String[] args) throws TwilioRestException {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
      
        // Build a filter for the SmsList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", "Don't Forget to take your "
                + "Trebek Quiz!"));
        params.add(new BasicNameValuePair("To", "+17037896173"));
        params.add(new BasicNameValuePair("From", "+17032935959"));
       
       
        SmsFactory smsFactory = client.getAccount().getSmsFactory();
        Sms sms = smsFactory.create(params);
        System.out.println(sms.getSid());
      
    }
}