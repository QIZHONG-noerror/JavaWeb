public class Student {
    String id;
    String name;
    private int MathScore;
    private int  ChineseScore;
    private int  EnglishScore;
    private int Average_Score;
    private int Total_Score;
    private String classType;

    public Student(){

    }

    public Student(String id,String name){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathScore() {
        return MathScore;
    }

    public void setMathScore(int mathScore) {
        MathScore = mathScore;
    }

    public int getChineseScore() {
        return ChineseScore;
    }

    public void setChineseScore(int chineseScore) {
        ChineseScore = chineseScore;
    }

    public int getEnglishScore() {
        return EnglishScore;
    }

    public void setEnglishScore(int englishScore) {
        EnglishScore = englishScore;
    }

    public int getAverage_Score() {
        return Average_Score;
    }

    public void setAverage_Score(int MathScore, int ChineseScore, int EnglishScore) {
        Average_Score = (MathScore + ChineseScore + EnglishScore)/3;
    }

    public int getTotal_Score() {
        return Total_Score;
    }

    public void setTotal_Score(int MathScore, int ChineseScore, int EnglishScore) {
        Total_Score = MathScore + ChineseScore + EnglishScore;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getScores(String Scoretype){
        //Student.setId(values[0]);
        //Student.setName(values[1]);
        if(Scoretype.equalsIgnoreCase("Math")){
            return getMathScore();
        }else if(Scoretype.equalsIgnoreCase("Chinese")){
            return getChineseScore();
        } else if (Scoretype.equalsIgnoreCase("English")) {
            return getEnglishScore();
        }else {
            return -1;
        }
    }

    public void SetScores(String line,String Scoretype){
        String[] values = line.split("\t");
        //Student.setId(values[0]);
        //Student.setName(values[1]);
        if(Scoretype.equalsIgnoreCase("MathScore")){
            this.setMathScore(Integer.parseInt(values[1]));
        }else if(Scoretype.equalsIgnoreCase("ChineseScore")){
            this.setChineseScore(Integer.parseInt(values[1]));
        } else if (Scoretype.equalsIgnoreCase("EnglishScore")) {
            this.setEnglishScore(Integer.parseInt(values[1]));
        }
    }
}

