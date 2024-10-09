

public class encapsulation {
    String firstname;
    String lastname;
    String email;
    String pass;

    public encapsulation(String firstname, String lastname, String email, String pass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.pass = pass;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
