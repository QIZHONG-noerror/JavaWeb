import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StudentFileReader extends StudentAbstractReader {
    /*
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
    }*/

        private File file;

        public StudentFileReader(File file) {
            this.setFile(file);
        }

        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }

    @Override
    public InputStream getInputSteam() throws FileNotFoundException {
        return new FileInputStream(this.getFile());
    }
}
