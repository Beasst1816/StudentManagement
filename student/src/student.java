import javax.imageio.stream.ImageInputStream;
import java.io.Serializable;

public class student implements Serializable{
    int rollnum;
    String name;
    String course;
    int marks;

    public student(String name,String cource,int rollnum, int marks) {
        this.name = name;
        this.course = cource;
        this.rollnum = rollnum;
        this.marks = marks;
    }

    public int getRollnum() {
        return rollnum;
    }
    public String getName() {
        return name;
    }
    public String getCource() {
        return course;
    }
    public int getMarks() {
        return marks;
    }

   public String toString(){
        return "student{"+
                ",name="+ name+'\''+
                ",marks="+marks+'\n'+
                ",cource="+course+"\n"+
                "rollnumber=" + rollnum +'}';

   }

}

