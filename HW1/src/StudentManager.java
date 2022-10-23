import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private static StudentManager instance = new StudentManager();
    private Map<String, Student> students = new HashMap<>();
    //List<Student> students = new ArrayList<>();
    public StudentManager(){

    }
    private Map<String,Student> getStudents(){
        return this.students;
    }
    /*打印所有学生信息：
    包含 “学号”，“姓名”，“语文”，”数学“，”外语“，”总分“，”平均分“
     */

    public static StudentManager getInstance(){
        return instance;
    }

    public int getTotalNumber(){
        return this.getStudents().size();
    }

    public void printAll(){
        /*return String.format("ID: %s, Name: %s,MathScore: %s,ChineseScore: %s,EnglishScore: %s", student.getId(),
                student.getName(),student.getMathScore(),student.getChineseScore(),student.getEnglishScore());
        */
        /*
        Map<String, Student> ss = this.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            System.out.println(String.format("ID: %s, Name: %s,MathScore: %s,ChineseScore: %s,EnglishScore: %s", student.getId(),
                    student.getName(), student.getMathScore(), student.getChineseScore(), student.getEnglishScore()));
        }*/
        Map<String, Student> ss = this.getStudents();
        for(Map.Entry<String, Student> entry : ss.entrySet()){
            Student student = entry.getValue();
            System.out.println(String.format(
                    "%s, %-5s, %s, %s, %s",
                    student.getId(), student.getName(), student.getMath(), student.getChinese(), student.getEnglish()
            ));
        }

    }

    public void visit(IStudentVisitor visitor){
        this.getStudents().forEach((key, val) -> {
            visitor.visit(val);
        });
    }

    public void addStudent(Student student){
        this.students.put(student.getId(), student);
    }

    public void deleteById(String id){
        this.getStudents().remove(id);
    }
    //根据学号查询学生信息
    public Student findById(String id){
        return this.students.get(id);
    }

    //根据课程类别，分值范围查询返回符合要求的学生列表;
    public List<Student> findByScore(ClassType classType, int min, int max) {
        /*
        Map<String, Student> ss = this.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            if(min <= student.getScores(ScoreType) && student.getScores(ScoreType) <= max){
                System.out.println(String.format("ID: %s, Name: %s, %s: %d",student.getId(),student.getName(),
                        ScoreType,student.getScores(ScoreType)));
            }

        }*/
        List<Student> result = new ArrayList<>();
        this.getStudents().forEach((id, student)->{
            int score = 0;
            switch (classType){
                case MATH -> {score = student.getMath();break;}
                case CHINESE -> {score = student.getChinese();break;}
                case ENGLISH -> {score = student.getEnglish();break;}
                default -> throw new IllegalArgumentException("wrong classtype");
            }

            if(score >= min && score <= max){
                result.add(student);
            }
        });
        return result;

    }
    //查询三科成绩平均分在指定范围内的学生列表;
    public List<Student> findByAverage(int min, int max){
        /*
        Map<String, Student> ss = this.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            if(min <= student.getAverage_Score() && student.getAverage_Score() <= max){
                System.out.println(String.format("ID: %s, Name: %s",student.getId(),student.getName()));
            }

        }*/
        List<Student> result = new ArrayList<>();
        this.getStudents().forEach((id,student)->{
            if(student.getAverage() >= min && student.getAverage() <= max){
                result.add(student);
            }
        });
        return result;
    }
    //返回一个列表，列表中的学生按总分由高到低排序;
    public List<Student> sortByTotal(){
        return this.sortByTotal(SortType.DESC);
    }
    public List<Student> sortByTotal(SortType sortType){
        List<Student> students = this.getStudents().values().stream().collect(Collectors.toList());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getTotal() > s2.getTotal()){
                    return sortType.equals(SortType.ASC) ? 1 : -1;
                } else if (s1.getTotal() < s2.getTotal()) {
                    return sortType.equals(SortType.ASC) ? -1 : 1;
                }else {
                    return 0;
                }
            }
        });
        return students;
    }
    /*
    将学生信息按 “学号”，“姓名”，“语文”，”数学“，”外语“，”总分“，”平均分“
    字段排列存另存到参数指定的文件中，字段用逗号隔开;
     */
    public void saveAs(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Map<String, Student> ss = this.getStudents();
        writer.write(String.format("学号，姓名，数学，语文，外语\n"));
        for(Iterator<String> it = ss.keySet().iterator(); it.hasNext();){
            String key = it.next();
            Student student = ss.get(key);
            writer.write(String.format(
                    "%s, %s, %s, %s, %s\n",
                    student.getId(), student.getName(), student.getMath(), student.getChinese(), student.getEnglish()
            ));
        }
        writer.close();
    }

    public Student getStudentById(String id){
        return this.students.get(id);
    }

}
