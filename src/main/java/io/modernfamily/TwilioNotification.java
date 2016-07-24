package io.modernfamily;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/******************************************
 * Text message based communications api  *
 ******************************************/

public class TwilioNotification {

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACf0754ef26af972a5f833c050efa40bf7";
    public static final String AUTH_TOKEN = "79c432c9692e378928c606c49fc1c6c1";
    public static String FROM_NUM = "+441622523191";
    public static String TO_NUM = "+447455083989";
    private static String MESSAGE_BODY = "Sam is en route to pick up Jenny. Please see http://bit.ly/29A4DdD for"+
            "more details.";

    /**************
     * Test method *
     **************/
    public static void main(String[] args) throws TwilioRestException {
        notify(TO_NUM, MESSAGE_BODY);
        System.out.println("[Success] Notification was sent.");
    }

    /*****************************************************************************
     * Sends a text notification to the given number with the specified message  *
     *****************************************************************************/
    public static void notify(String toNum, String msg) {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", MESSAGE_BODY));
        params.add(new BasicNameValuePair("To", TO_NUM));
        params.add(new BasicNameValuePair("From", FROM_NUM));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = null;
        try {
            message = messageFactory.create(params);
        } catch (TwilioRestException e) {
            System.out.println("[System exception] Could not use TwilioNotification.notify() to send text alert!");
        }
        System.out.println("[Success] Message signature (id): "+message.getSid());
    }
}