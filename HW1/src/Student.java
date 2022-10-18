public class Student {
    String id;
    String name;
    String MathScore;
    String ChineseScore;
    String EnglishScore;

    public Student(){

    }

    public Student(String id,String name){

    }

    public void setId(String Id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public String getMathScore() {
        return MathScore;
    }

    public void setMathScore(String mathScore) {
        this.MathScore = mathScore;
    }

    public String getChineseScore() {
        return ChineseScore;
    }

    public void setChineseScore(String chineseScore) {
        this.ChineseScore = chineseScore;
    }

    public String getEnglishScore() {
        return EnglishScore;
    }

    public void setEnglishScore(String englishScore) {
        this.EnglishScore = englishScore;
    }
}
