import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class StudentHttpReader {
    public static List<String> getFile(String urlPath){
        System.out.println("Start to get file from URL...");
        List<String> student = new ArrayList<>();
        URL url;
        try{
            url = new URL(urlPath);
            URLConnection connection = url.openConnection();;
            connection.connect();
            HttpURLConnection httpCon = (HttpURLConnection) connection;
            if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader StudentHttpReader = new InputStreamReader(httpCon.getInputStream());
                BufferedReader HttpBReader = new BufferedReader(StudentHttpReader);
                String line;
                while((line = HttpBReader.readLine()) != null){
                    System.out.println(line);
                    student.add(line);
                }
            }else{
                System.out.println("Cannot connect to the" + urlPath);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished getting the data from URL");
        return student;
    }




}
