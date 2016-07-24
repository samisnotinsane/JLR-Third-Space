package io.modernfamily;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created by sameenislam on 24/07/2016.
 * Gets configuration info required for the Azure cloud platform.
 */

public class AzureGetPropertyValues {
    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();

            // Detect path where system checks for config.properties
//            String absolute = getClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm();
//            System.out.println("absolute = "+absolute); (debug print)

            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


            // get the property value and print it out
            String faceApiKey = prop.getProperty("FACE_API_KEY");

            result = faceApiKey;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}