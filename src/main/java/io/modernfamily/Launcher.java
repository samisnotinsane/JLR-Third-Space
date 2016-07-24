package io.modernfamily;

import java.io.IOException;

import static io.modernfamily.FaceApi.detect;

/**
 * Created by sameenislam on 24/07/2016.
 * For demonstrating apis.
 */
public class Launcher {

    public static void main(String[] args) {


        /***************************************************
         * Demonstrates facial recognition authentication  *
         ***************************************************/
        System.out.println("[INITIALISING SYSTEM] Please wait...\n\n");
        // Initialise identity (of stored face) to get first faceId
        String storedFaceId = detect("face.png");
        System.out.println("Authenticated faceId: " + storedFaceId);

        // Take new image, run recognition on it and get new faceId
        try {
            CaptureFacial.store("face1.png");
        } catch (IOException e) {
            System.out.println("[System exception] Failed to store image for face detection");
        }

        String capturedFaceId = FaceApi.detect("face1.png");
        System.out.println("Attempted login faceId: " + capturedFaceId);

        // Compare two faceId using Verify api
        boolean authenticated = FaceApi.verify(storedFaceId, capturedFaceId);
        if(authenticated)
            System.out.println("[SUCCESS] Welcome, Sam.");
        else
            System.out.println("[FAIL] Access denied.");


        /*******************************************
         * Demonstrates text message notification  *
         *******************************************/

        String msgBody = "Sam is en route to pick up Jenny. Please see http://bit.ly/29A4DdD for"+
                "more details.";
        TwilioNotification.notify(TwilioNotification.TO_NUM, msgBody);
        System.out.println("[SUCCESS] Notification was sent.");
    }
}
