package io.modernfamily;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;

/**
 * Created by sameenislam on 24/07/2016.
 *
 * Bing Voice Recognition API by Microsoft Azure Cognitive Services
 */
public class VoiceRecognition {

    private static String key = null;
    private final static String CLIENT_ID = "c827260e-136f-4da4-b67c-91219f802e77";

    public static void auth() {

        // access key
        AzureGetPropertyValues properties = new AzureGetPropertyValues();
        try {
            key = properties.getVoicePropValues();
        } catch (IOException e) {
            System.out.println("[System exception] An error occurred while attempting to read api key.");
        }


        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/speech/v0/internalIssueToken");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);



            // Request body
            StringEntity reqEntity = new StringEntity("{\n" +
                    "    \"client_id\":\"" + CLIENT_ID + "\" \n" +
                    "}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        // ----


//
//
//        String result = "";
//        HttpClient httpclient = HttpClients.createDefault();
//
//        try
//        {
//            URIBuilder builder = new URIBuilder("https://oxford-speech.cloudapp.net/token/issueToken");
//            String q = "https://speech.platform.bing.com";
//            String uriEncodedString = URLEncoder.encode(q, "UTF-8");
//
//            URI uri = builder.build();
//            HttpPost request = new HttpPost(uri);
//            request.setHeader("Content-Type", "application/x-www-form-urlencoded");
//            request.setHeader("grant_type", "client_credentials");
//            request.setHeader("client_id", key);
//            request.setHeader("client_secret", key);
//            request.setHeader("scope", uriEncodedString);
//
//            // Request body
////            StringEntity reqEntity = new StringEntity("{\n" +
////                    "    \"faceId1\":\"" + strA + "\",\n" +
////                    "    \"faceId2\":\"" + strB + "\" \n" +
////                    "}");
////            request.setEntity(reqEntity);
//
//            HttpResponse response = httpclient.execute(request);
//            HttpEntity entity = response.getEntity();
//
//            if (entity != null)
//            {
//                result = EntityUtils.toString(entity);
//                System.out.println(result);
//            }
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
    }

    public static void main(String[] args) {
        auth();
    }


}
