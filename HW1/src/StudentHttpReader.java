import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

class StudentHttpReader extends StudentAbstractReader{
    /*
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
    */
    private URL url;
    public StudentHttpReader(URL url){
        this.setUrl(url);
    }

    @Override
    public InputStream getInputSteam() throws IOException {
        URLConnection connection = this.getUrl().openConnection();
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
