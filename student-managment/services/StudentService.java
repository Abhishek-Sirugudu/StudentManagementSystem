package services;
// import StudentNotFoundException;
import Exceptioins.StudentNotFoundException;
import models.Student;
import java.util.*;
public class StudentService {

    public List<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return copy for encapsulation
    }

    public Student getStudentbyId(String id) throws StudentNotFoundException{
        for(Student st : students){
            if(st.getId().equals(id)){
                return st;
            }
        }

        throw new StudentNotFoundException("Student with :" +id +" not Found");
    }

    public void updateStudent(String id, String newBranch, double newMarks) 
            throws StudentNotFoundException {
        Student student = getStudentbyId(id);
        student.setBranch(newBranch);
        student.setMarks(newMarks);
    }
    
    // Delete student
    public void deleteStudent(String id) throws StudentNotFoundException {
        Student student = getStudentbyId(id);
        students.remove(student);
    }



}
