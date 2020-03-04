package Data;

import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;
import com.google.gson.JsonObject;
import javax.xml.bind.JAXBException;
import java.io.IOException;


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


    public String stringify ()throws IOException {
                JsonObject stud = new JsonObject();
                stud.addProperty("Name",name);
                stud.addProperty("University",university);
                stud.addProperty("RollNo",rollNo);
                return stud.toString();

        }



    public String getRollNo(){
        return rollNo;
    }
    public  String getName() { return name; }
    public String getUniversity() {return university;}

}
