import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
    private File file;
    Student student;
    static List<Student> studentList = new ArrayList<>();

    public StudentReader(){

    }
    /*public List<Student> read() throws IOException {
        List<Student> students = new ArrayList<>();
        try(InputStreamReader inputStreamReader = new InputStreamReader(this.getInputStream())){
            try(BufferedReader reader = new BufferedReader(inputStreamReader)){
                String line = null;
                while((line = reader.readLine()) != null){
                    if(line.trim().isEmpty()) continue;
                    Student student = this.createStudent(line);
                    students.add(student);
                }
            }
        }
        return students;
    }*/

    private Student createStudent(String line){
        String[] vals = line.split("\t");
        Student student = new Student();
        student.setId(vals[0]);
        student.setName(vals[1]);
        return student;

    }

    //文件读取
    public void StudentFileReader(File file){
        this.setFile(file);
    }
    public InputStream getFileInputStream() throws FileNotFoundException {
        return new FileInputStream(this.getFile());
    }
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    //url读取
    private URL url;
    public void StudentHttpReader(URL url){
        this.setUrl(url);
    }

    public InputStream getHttpInputStream() throws IOException {
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


    //Reader选择
    /*public static <IStudentReader> IStudentReader create(String url){

    }*/
}
