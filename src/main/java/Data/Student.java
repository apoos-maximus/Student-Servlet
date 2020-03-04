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


    public String stringify (String format)throws IOException {
        if(!format.equals(null)){
            if(format.equals("application/xml")){
                ObjectMapper jsonMapper  = new ObjectMapper();
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.writeValueAsString(this);
            } else {
                JsonObject stud = new JsonObject();
                stud.addProperty("Name",name);
                stud.addProperty("University",university);
                stud.addProperty("RollNo",rollNo);
                return stud.toString();
            }
        } else {
            return "unknown format requested";
        }

    }

    public String getRollNo(){
        return rollNo;
    }
    public  String getName() { return name; }
    public String getUniversity() {return university;}

}
