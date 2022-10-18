public class Main {
    public static void main(String[] args){
        //String LocalTxtPath = "C:\\students.txt";
        //StudentFileReader.getFile(LocalTxtPath);

        String uri_math = "http://139.186.26.196/javaweb/data/math.txt";
        StudentHttpReader.getFile(uri_math);
    }
}
