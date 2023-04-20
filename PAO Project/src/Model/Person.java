package Model;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String _firstName, String _lastName, Integer _age) {
        super();
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", age=" + this.age +
                '}';
    }
}
