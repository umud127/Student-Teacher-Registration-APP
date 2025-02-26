package Student;

public class Student {

    //values student must have
    private int id;                 //primary key   //NN
    private String firstName;       //NN
    private String lastName;        //NN
    private int age;                //NN

    //values student can have
    private boolean hasTeacher;     //auto false

    private String email;           //auto null
    private String teacherName;     //auto null

    //constructor for creating
    public Student(String firstName, String lastName, String email, int age, boolean hasTeacher, String teacherName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.hasTeacher = hasTeacher;
        this.teacherName = teacherName;
    }

    //constructor for update 1 (Student_Info_CRUD)
    public Student(String firstName, String lastName, String email, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    //constructor for update 2 (Has_Teacher_CRUD)
    public Student(boolean hasTeacher, String teacherName, int id) {
        this.hasTeacher = hasTeacher;
        this.teacherName = teacherName;
        this.id = id;
    }


    //getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getHasTeacher() {
        return hasTeacher;
    }

    public void setHasTeacher(boolean hasTeacher) {
        this.hasTeacher = hasTeacher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}