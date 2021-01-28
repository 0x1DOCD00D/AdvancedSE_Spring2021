public class Student {
    private int UIN;
    private String name;
    private float gpa;
    private int cnter = 0;
    private Student intObject = null;

    static void builder() {
        Object o;
        intObject = new Student();
    }
    
    public static Student done() {
        if( cnter == 3)
            return this;
        return null;
    }
    
    public Student specifyName(String name) {
        ++cnter;
        this.name = name;
        return this;
    }

    public Student assignID(int id) {
        ++cnter;
        this.UIN = id;
        return this;
    }

    public Student setGrade(float g) {
        ++cnter;
        this.gpa = g;
        return this;
    }

    public static void main(String[] args) {
        Student st1 = new Student();
        st1.specifyName("d");
        st1.assignID(1);
        
        Student st = Student.builder().specifyName("Linfeng").assignID(1).done();
        System.out.println(st);
    }
}
