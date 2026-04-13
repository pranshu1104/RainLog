package com.example.demo.simulation;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class DataGenerator {
    public double[] generateCoordinates(){
        double[] data = new double[2];
        data[0]=28.40+Math.random()*(28.55-28.40);
        data[1]= 76.95 +Math.random()*(77.10-76.95);
        return data;
    }
    public static void main(String[]args){
        HttpClient client = HttpClient.newHttpClient();

        DataGenerator dg = new DataGenerator();
        for(int i=0;i<20;i++) {
            double[] data = dg.generateCoordinates();
            int severity = (int)( 0.0+Math.random()*(10.0-0.0));
            String json = "{\"latitude\":"+data[0]+
                    ",\"longitude\":"+  data[1]+
                    ",\"severity\":"+severity+"}";
            try {
                URL url = new URL("http://localhost:8080/reports");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);
                OutputStream os = conn.getOutputStream();
                os.write(json.getBytes());
                os.flush();
                os.close();
                int responseCode = conn.getResponseCode();
              //  System.out.println(responseCode);
            }catch(Exception e){
                e.printStackTrace();
            }
          // System.out.println(data[0]+","+data[1]+","+severity);
        }
    }
}
