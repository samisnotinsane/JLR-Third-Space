package io.modernfamily;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by sameenislam on 23/07/2016.
 * Allows the consuming of RESTful APIs using the Jersey for Java library.
 */
public class RestApi {

    public static void enrollFace() {
        String baseuri = "https://api.kairos.com/enroll";

        try {
            Client client = Client.create();

            WebResource webResource = client.resource(baseuri);

            String input = "{\"switch\": \"00:00:00:00:00:00:00:01\", "
                    + "\"name\":\"flow-mod-1\", \"priority\":\"32768\", "
                    + "\"ingress-port\":\"1\",\"active\":\"true\", "
                    + "\"actions\":\"output=2\"}";

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, input);

            // check response status code
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{

//      The Client class is the main configuration point for building a RESTful web service client.

//      To issue requests, you need to create a WebResource object, which encapsulates a web resource
//      for the client. For example, the following code creates a WebResource object for a web resource
//      whose URI is http://example.com/base:

        Client client = Client.create();
        WebResource webResource = client.resource("https://jsonplaceholder.typicode.com/posts");

//      GET Request: Use the get() method in the WebResource class to submit an HTTP GET request
//      to the web resource
//        String s = webResource.get(String.class);

        String s = webResource.accept("text/json").get(String.class);

        System.out.println("s: "+s);
//      Get the HTTP status code for the request

    }
}
