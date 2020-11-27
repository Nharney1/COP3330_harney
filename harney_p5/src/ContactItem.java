public class ContactItem {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email){

        if (firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && email.isBlank()){
            throw new IllegalArgumentException("WARNING: A contact must have at least one piece of contact information.");
        }
        else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

    }

    public void updateContactItem (String firstName, String lastName, String phoneNumber, String email){

        if (firstName.isBlank() && lastName.isBlank() && phoneNumber.isBlank() && email.isBlank()){
            throw new IllegalArgumentException("WARNING: A contact must have at least one piece of contact information.");
        }
        else {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString(){
        return (getFirstName() + " " + getLastName() + " " + getPhoneNumber() + " " + getEmail());
    }
}
