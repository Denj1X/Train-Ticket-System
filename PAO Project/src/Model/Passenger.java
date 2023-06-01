package Model;

public class Passenger extends Person{
    private String email;
    private String contactNumber;
    private String password;
    public Passenger(String _firstName, String _lastName, Integer _age, String _email, String _contactNumber, String _password) {
        super(_firstName, _lastName, _age);
        this.email = _email;
        this.contactNumber = _contactNumber;
        this.password = _password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "email='" + this.getEmail() + '\'' +
                ", contactNumber='" + this.getContactNumber() +
                '}';
    }
}
