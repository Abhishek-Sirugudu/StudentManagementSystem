package models;
public class Student {
    private String name;
    private String id;
    private String branch;
    private double marks;

    public Student(String name, String id, String branch, Double marks) {
        this.branch = branch;
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getBranch() {
        return branch;
    }

    public String getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

   

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Branch: " + branch + ", Marks: " + marks;
    }
}