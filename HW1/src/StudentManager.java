import java.util.*;

public class StudentManager {
    Student student = new Student();

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
    public String printAll(){
        /*return String.format("ID: %s, Name: %s,MathScore: %s,ChineseScore: %s,EnglishScore: %s", student.getId(),
                student.getName(),student.getMathScore(),student.getChineseScore(),student.getEnglishScore());
        */
        Map<String, Student> ss = this.getStudents();
        for (Iterator<String> it = ss.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            Student student = ss.get(key);
            System.out.println(String.format("ID: %s, Name: %s,MathScore: %s,ChineseScore: %s,EnglishScore: %s", student.getId(),
                    student.getName(),student.getMathScore(),student.getChineseScore(),student.getEnglishScore()));
        }
    }

    //根据学号查询学生信息
    public Student getStudentById(String id){
        return this.getStudents().get(id);
    }

    //根据课程类别，分值范围查询返回符合要求的学生列表;
    public void findByScore(String classType, int min, int max) {
        System.out.println("studying");
    }
    //查询三科成绩平均分在指定范围内的学生列表;
    public void findByScore(int min, int max){
        System.out.println("studying");
    }
    //返回一个列表，列表中的学生按总分由高到低排序;
    public void sortByTotal(){
        System.out.println("studying");
    }
    /*
    将学生信息按 “学号”，“姓名”，“语文”，”数学“，”外语“，”总分“，”平均分“
    字段排列存另存到参数指定的文件中，字段用逗号隔开;
     */
    public void saveAs(String filePath){
        System.out.println("studying");
    }


}
