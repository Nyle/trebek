//import com.twilio.sdk.TwilioRestClient;
//import com.twilio.sdk.TwilioRestException;
//import com.twilio.sdk.resource.factory.MessageFactory;
//import com.twilio.sdk.resource.instance.Message;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
// 
//import java.util.ArrayList;
//import java.util.List;
// 
//public class TestCase {
// 
//    // Find your Account Sid and Token at twilio.com/user/account
//    public static final String ACCOUNT_SID = "AC0b5455ab5953910c7ab2cfc5492c9c0d";
//    public static final String AUTH_TOKEN = "bcb33238698a9c946b19408d0140b166";
// 
//    public static void main(String[] args) throws TwilioRestException {
//        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
// 
//        // Build a filter for the MessageList
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("Body", "HelloWorld!"));
//        params.add(new BasicNameValuePair("To", "7032327549"));
//        params.add(new BasicNameValuePair("From", "(540) 798-8062"));
// 
//        MessageFactory messageFactory = client.getAccount().getMessageFactory();
//        Message message = messageFactory.create(params);
//        System.out.println(message.getSid());
//    }
//}
//
//import java.util.*;
//
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//
//import com.twilio.sdk.*; 
//import com.twilio.sdk.resource.factory.*; 
//import com.twilio.sdk.resource.instance.*; 
//import com.twilio.sdk.resource.list.*; 
// 
//public class SendText { 
// // Find your Account Sid and Token at twilio.com/user/account 
//    public static final String ACCOUNT_SID = "AC0b5455ab5953910c7ab2cfc5492c9c0d";
//    public static final String AUTH_TOKEN = "bcb33238698a9c946b19408d0140b166"; 
// 
// public static void main(String[]args) throws TwilioRestException { 
//  TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
// 
//   // Build the parameters 
//   List<NameValuePair> params = new ArrayList<NameValuePair>(); 
//   params.add(new BasicNameValuePair("To", "7032327549")); 
//   params.add(new BasicNameValuePair("From", "7032327549")); 
//   params.add(new BasicNameValuePair("Body", "helloWorld")); 
//   params.add(new BasicNameValuePair("MediaUrl", "http://farm2.static.flickr.com/1075/1404618563_3ed9a44a3a.jpg"));  
// 
//   MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
//   Message message = messageFactory.create(params); 
//   System.out.println(message.getSid()); 
// } 
//}

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 
public class SendText {
 
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC0b5455ab5953910c7ab2cfc5492c9c0d";
  public static final String AUTH_TOKEN = "bcb33238698a9c946b19408d0140b166"; 
 
  public static void main(String[] args) throws TwilioRestException {
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
    // Build a filter for the MessageList
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("Body", "HelloWorld"));
    params.add(new BasicNameValuePair("To", "+17032327549"));
    params.add(new BasicNameValuePair("From", "+15407988062"));
 
    MessageFactory messageFactory = client.getAccount().getMessageFactory();
    Message message = messageFactory.create(params);
    System.out.println(message.getSid());
  }
}