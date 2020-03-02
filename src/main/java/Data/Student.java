package Data;

import com.google.gson.JsonObject;

public class Student {
    private String name;
    private String university;
    private String rollNo;


    {
        name = "";
        university = "";
        rollNo = "";
    }

    public Student(String nameParam, String universityParam, String rollNoParam){
        name = nameParam;
        university = universityParam;
        rollNo = rollNoParam;
    }
    public Student(){

    }

    public String stringify(){
        JsonObject stud = new JsonObject();
        stud.addProperty("Name",name);
        stud.addProperty("University",university);
        stud.addProperty("RollNo",rollNo);
        return stud.toString();
    }

    public String getRollNo(){
        return rollNo;
    }

}
