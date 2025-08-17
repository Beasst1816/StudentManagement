import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement{
    static final String file_name = "student database.txt";
    static ArrayList<student> student1 = new ArrayList<>();

    public  static student topper(ArrayList<student> student1){
            if(student1.isEmpty())return null;
        student top = student1.get(0);
            for(student t: student1){
                if(t.marks > top.getMarks()){
                top = t;
                }
            }
         return top;
        }

    @SuppressWarnings("Unchecked")
    static void savedata(){
        try
            (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file_name))){
                 oos.writeObject(student1);

oos.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @SuppressWarnings("unchecked")
    static void loadData(){
       try
               (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name))){
               student1 = (ArrayList<student>) ois.readObject();

ois.close();
       }catch(Exception e){
            student1 = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
           File file = new File("student database.txt");
            StudentManagement mngmn = new StudentManagement();
            loadData();


            while(true){
                System.out.println("take choice you want ");
                System.out.println("1 , 2 , 3 , 4 ,5\n" +
                "1 :  for add student\n"+
                                "2 : for all student details \n"+
                        "3 :for percentage\n"+
                        "4 : for find toper\n"+
                        "5 : for student search by roll num \n"+
                        "6 : for delete student \n"+
                        "7 : for exit"

                );
                Scanner r = new Scanner(System.in);
                int choice= r.nextInt();
                if(choice == 1){

                    mngmn.addstudent();
                    System.out.println("student added");
                    savedata();
                }
                else if (choice == 2){
                    System.out.println("here is the all student list ");
                    mngmn.displaystudent();
                } else if (choice == 3) {
                    System.out.println(mngmn.percentage(student1));

                } else if (choice == 4) {
                    System.out.println(topper(student1));

                } else if (choice == 5) {
                    System.out.println("enter roll num of student you want");
                    int S = r.nextInt();
                    student result = mngmn.searchbyroll(student1,S);
                    if(result != null){
                        System.out.println("hare is your student \n"+result);
                    }else{
                        System.out.println("enter valid num");
                    }
                } else if (choice == 6) {
                    System.out.println("enter roll number of student you want to remove");
                    int rem = r.nextInt();
                    mngmn.delete(student1,rem);
                    savedata();
                } else if(choice == 7) {
                    System.out.println("closing");
                    break;
                }else{
                    System.out.println("enter valid num");
                }

                }
savedata();
            }

    public void addstudent(){
        Scanner sc = new Scanner(System.in);

        System.out.println("enter student name");
        String name = sc.nextLine();

        System.out.println("enter student course");
        String course = sc.nextLine();


        System.out.println("enter student rollnumber");
        int roll = sc.nextInt();


        System.out.println("enter student marks");
        int marks = sc.nextInt();

            student1.add(new student(name,course,roll,marks));
    }

    public void displaystudent () {
        if (student1.isEmpty()){
            System.out.println("there is no student");
        }
        else{
            for(student s : student1){
                System.out.println(s);
            }
        }
    }

        public double percentage(ArrayList<student> student1){
           int total = 0;
           for(student x : student1){
               total += x.getMarks();
           }
            return student1.size() > 0 ? (double) total / student1.size() : 0;
        }

    public  student  searchbyroll(ArrayList<student>student1,int Roll) {
        for(student ss:student1){
            if(ss.getRollnum() == Roll){
                return ss;
            }
        }
return null;
            }

            public void delete(ArrayList<student> student1,int rem){
        boolean removed = false;
        for(int i = 0; i < student1.size();i++){
              student1.remove(i);
                System.out.println(" the student with rollnum "+rem+" is removed" );
                removed = true;

                if(!removed){
                    System.out.println("not found with rollnum "+rem);
                }
break;
        }}
        }






