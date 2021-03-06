package db;
import Data.Student;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

public class StudentDb{
    private HashMap<String,Student> db;

    public StudentDb(){
        db = new HashMap<>();
    }
    public String insertRow(Student stud) { //post
        db.put(stud.getRollNo(),stud);
        return "true";
    }
    public Student getByRollNo(String roll) { //get
        if(db.containsKey(roll)){ // basics
            return db.get(roll);
        }
        else return new Student("empty","empty","empty");
    }
}
