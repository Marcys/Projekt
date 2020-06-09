package sample;

public class Product {

    private String course;
    private int member;
    private String deadline;

    public Product(){
        this.course = "";
        this.member = 0;
        this.deadline = "";
    }

    public Product(String course, int member, String deadline){
        this.course = course;
        this.member = member;
        this.deadline = deadline;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}