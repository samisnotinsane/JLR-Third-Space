package io.modernfamily;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by sameenislam on 23/07/2016.
 * Allows the consuming of RESTful APIs using the Jersey for Java library.
 */
public class RestApi {


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

        String s = webResource.accept("text/plain").get(String.class);

        System.out.println("s: "+s);
//      Get the HTTP status code for the request

    }
}
