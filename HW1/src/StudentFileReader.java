import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {
    public static List<String> getFile(String filePath){
        System.out.println("Starting to get file...");
        List<String> student = new ArrayList<>();
        File file = new File(filePath);
        try {
            InputStream StudentFileInputStream = new FileInputStream(file);
            BufferedReader FileBReader = new BufferedReader(new InputStreamReader(StudentFileInputStream));
            String line;
            while ((line = FileBReader.readLine()) != null){
                System.out.println(line);
                student.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished getting file......");
        return student;
    }

    private Student createStudent(Student student,String line){
        String[] values = line.split("\t");
        student.setId(values[0]);
        student.setName(values[1]);

        return student;
    }



}
