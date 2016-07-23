package io.modernfamily;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by sameenislam on 23/07/2016.
 * Encodes image to/from Base64
 */
public class Base64Encoder {

    // Convert a png image to base64 string and return it
    public static String encode(BufferedImage image) {
        String type = "png"; // make this fn specific to png images
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static BufferedImage decode(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }


    public static void main(String[] args) {
        System.out.println("[Encoding image...]");

        // Load image file
        BufferedImage img = null;
        try {
            if(img == null)
                System.out.println("[img==null]");
            img = ImageIO.read(new File("face.png"));
//            if(img != null)
            System.out.println("[img!=null]");
        } catch (IOException e) {
            System.out.println("[System exception] could not load image!");
        }

        String encodedImage = encode(img);
        System.out.println(encodedImage+"\n\n[Image successfully encoded]\n\n");

        System.out.println("[Decoding image...]");
        BufferedImage decImage = decode(encodedImage);
        System.out.println("\n\n[Image successfully decoded]");
    }
}
