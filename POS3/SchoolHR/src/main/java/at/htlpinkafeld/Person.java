package at.htlpinkafeld;

public class Person {
    private String firstName;
    private String lastName;
    private long socSecNum;

    public Person(String firstName, String lastName, long socSecNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socSecNum = socSecNum;
    }

    public long getSocSecNum() {
        return socSecNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toJSON() {
        return "{\n" +
                "  \"Person\": {\n" +
                "    \"firstName\": \"" + this.firstName + "\",\n" +
                "    \"lastName\": \"" + this.lastName + "\",\n" +
                "    \"socSecNum\": \"" + this.socSecNum + "\"\n" +
                "  }\n" +
                "}";
    }

}
