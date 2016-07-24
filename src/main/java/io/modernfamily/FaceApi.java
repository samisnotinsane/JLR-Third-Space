package io.modernfamily;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Created by sameenislam on 24/07/2016.
 *
 * Detect human faces and compare similar ones, organize people into groups
 * according to visual similarity, and detect previously tagged people in images.
 *
 * Uses Microsoft Azure Cognitive Services.
 */

public class FaceApi {

    private static String key = null;

    public static String detect(String filename) {
        String result = "";
        AzureGetPropertyValues properties = new AzureGetPropertyValues();

        try {

            key = properties.getPropValues();
            System.out.println("key = "+key);
        } catch (IOException e) {
            System.out.println("[System exception] An error occurred while attempting to read api key.");
        }

        try
        {
            HttpClient httpclient = HttpClients.createDefault();

            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/detect");

            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");
            builder.setParameter("returnFaceAttributes", "gender");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", key);

            // Open image and process it
            File file = new File(filename);
            FileEntity fEntity = new FileEntity(file, "binary/octet-stream");
            String bs = EntityUtils.toString(fEntity);

            // Request body
            StringEntity reqEntity = new StringEntity(bs);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                result = EntityUtils.toString(entity);
//                System.out.println(EntityUtils.toString(entity));

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        String faceID = "";

        // Parse JSON and extract faceId
        JSONArray jsonArray = new JSONArray(result);
        for(int i=0; i<1; i++)
            faceID = jsonArray.getJSONObject(i).getString("faceId");

//        JSONObject obj = new JSONObject(jsonArray);
//        String n = obj.getJSONObject("face").getString("faceId");
//        System.out.println("faceId = " + faceID);

        return faceID;
    }

    public static boolean verify(String strA, String strB) {

        String result = "";
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/face/v1.0/verify");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);


            // Request body
            StringEntity reqEntity = new StringEntity("{\n" +
                    "    \"faceId1\":\"" + strA + "\",\n" +
                    "    \"faceId2\":\"" + strB + "\" \n" +
                    "}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                result = EntityUtils.toString(entity);
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        String isIdentical = "";
        String confidence = "";
//        System.out.println("result*** = = "+ result);

        // Parse JSON results
//        JSONArray jsonArray = new JSONArray(result);
//        isIdentical = jsonArray.getJSONObject(0).getString("isIdentical");
//        confidence = jsonArray.getJSONObject(1).getString("confidence");

        JSONObject obj = new JSONObject(result);

//        System.out.println("obj.toString = "+obj.toString());
        boolean n = obj.getBoolean("isIdentical");
//        System.out.println("isIdentical="+n);
        double m = obj.getDouble("confidence");
        System.out.println("confidence="+m);
//        System.out.println("isIdentical = " + n + ", confidence = "+ m);


        if (isIdentical.equals("true") || m > 0.65)
            return true;
        else
            return false;
    }

    public static void main(String[] args)
    {
        // Initialise identity (of stored face) to get first faceId
        String storedFaceId = detect("face.png");
        System.out.println("Authenticated faceId: " + storedFaceId);

        // Take new image, run recognition on it and get new faceId
        try {
            CaptureFacial.store("face1.png");
        } catch (IOException e) {
            System.out.println("[System exception] Failed to store image for face detection");
        }

        String capturedFaceId = detect("face1.png");
        System.out.println("Attempted login faceId: " + capturedFaceId);

        // Compare two faceId using Verify api
        boolean authenticated = verify(storedFaceId, capturedFaceId);
        if(authenticated)
            System.out.println("Welcome, Sameen.");
        else
            System.out.println("Access denied.");

    }

}
