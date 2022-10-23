import java.io.*;

public class ScoreFileReader extends ScoreAbstractReader{
    private File file;

    public ScoreFileReader(File file){
        this.setFile(file);
    }

    public InputStream getInputStream() throws FileNotFoundException {
        return new FileInputStream(this.getFile());
    }

    private File getFile() {
        return file;
    }

    private void setFile(File file) {
        this.file = file;
    }
}
