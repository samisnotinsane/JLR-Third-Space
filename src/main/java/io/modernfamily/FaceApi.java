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
        System.out.println("faceId = " + faceID);

        return faceID;
    }

    public static void verify(String strA, String strB) {

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
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args)
    {

        // Initialise identity (of stored face) to get first faceId
        System.out.println(detect("face.png"));

        // Take new image, run recognition on it and get new faceId
        try {
            CaptureFacial.capture("face1.png");
        } catch (IOException e) {
            System.out.println("[System exception] Failed to capture image for face detection");
        }
        System.out.println(detect("face1.png"));
//        verify();
        // Compare two faceId using Verify api

    }

}
