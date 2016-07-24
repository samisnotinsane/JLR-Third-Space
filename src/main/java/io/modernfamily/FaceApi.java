package io.modernfamily;

import com.sun.jersey.core.util.Base64;
import com.uploadcare.api.Client;
import com.uploadcare.upload.FileUploader;
import com.uploadcare.upload.UploadFailureException;
import com.uploadcare.upload.Uploader;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.snmp4j.smi.OctetString;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

/**
 * Created by sameenislam on 24/07/2016.
 *
 * Detect human faces and compare similar ones, organize people into groups
 * according to visual similarity, and identify previously tagged people in images.
 *
 * Uses Microsoft Azure Cognitive Services.
 */

public class FaceApi {

    private static String key = null;

    public static String identify() {
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
            File file = new File("face.png");
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

        return result;
    }


    public static void main(String[] args)
    {
        System.out.println(identify());

    }

}
