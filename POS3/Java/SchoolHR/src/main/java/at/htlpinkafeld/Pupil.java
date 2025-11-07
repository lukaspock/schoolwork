package at.htlpinkafeld;

public class Pupil extends Person{
    private String className;

    public Pupil(String className, String firstName, String lastName, long socSecNum) {
        super(firstName,lastName,socSecNum);
        this.className = className;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String toJSON() {
        return "Pupil : {\n" + super.toJSON() +
                ", 'className': '" + className + "'" +
                "}";
    }
}
