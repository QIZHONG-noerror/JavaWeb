public class StudentManager {
    /*打印所有学生信息：
    包含 “学号”，“姓名”，“语文”，”数学“，”外语“，”总分“，”平均分“
     */
    public void printAll(){
        System.out.println("working");
    }

    //根据学号查询学生信息
    public void getStudentById(String id){
        System.out.println("studying");
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
