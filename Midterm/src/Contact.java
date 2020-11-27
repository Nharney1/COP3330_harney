public class Contact {

    private String name;
    private String email;
    private String phoneNumber;

    public Contact (String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }
    public void setName( String newName){
        name = newName;
    }

    public String getEmail (){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String newNumber){
        phoneNumber = newNumber;
    }

    @Override
    public String toString(){
        return "Name: " + name + " " + "Email: " + email + " " + "Phone Number: " + phoneNumber;
    }
}
