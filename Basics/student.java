package Basics;

public class Student {
private int stdId=5;
private String stdName="Default Name";
 public Student(String stdName, int stdId) {
        this.stdId = stdId;
        this.stdName = stdName;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

}