        import org.apache.commons.httpclient.*;
        import org.apache.commons.httpclient.methods.*;
        import java.io.*;

        public class HttpClientTutorial {
          
          private static String url = "http://www.apache.org/";

          public static void main(String[] args) {
            // Create an instance of HttpClient.
            HttpClient client = new HttpClient();
			
            // Create a method instance.
            HttpMethod method = new GetMethod(args[0]);

            // Execute the method.
            int statusCode = -1;
            int attempt = 0;
            // We will retry up to 3 times.
            while (statusCode == -1 && attempt < 3) {
              try {
                // execute the method.
                statusCode = client.executeMethod(method);
              } catch (HttpRecoverableException e) {
                System.err.println(
                  "A recoverable exception occurred, retrying." + 
                  e.getMessage());
              } catch (IOException e) {
                System.err.println("Failed to download file.");
                e.printStackTrace();
                System.exit(-1);
              }
            }
            // Check that we didn't run out of retries.
            if (statusCode == -1) {
              System.err.println("Failed to recover from exception.");
              System.exit(-2);
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Release the connection.
            method.releaseConnection();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.err.println(new String(responseBody));
          }
        }
