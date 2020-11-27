import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ContactList  {

    protected List<ContactItem> list = new ArrayList<>();


    public ContactItem get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void add (ContactItem item){
        list.add(item);
    }

    public void delete(int index){
        if (index > list.size() -1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to delete does not exist. %n");
        }
        else {
            list.remove(index);
        }
    }

    public void editItem(String firstName, String lastName, String phoneNumber, String email, int index){
        if (index > list.size() -1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to edit does not exist");
        }
        else {
            list.get(index).updateContactItem(firstName, lastName, phoneNumber, email);
        }
    }

    public void saveFile(){
        if(list.size() > 0){
            try(Formatter output = new Formatter("Contact.txt")){
                for (ContactItem item : list){
                    output.format("%s%n", item.getFirstName());
                    output.format("%s%n", item.getLastName());
                    output.format("%s%n", item.getPhoneNumber());
                    output.format("%s%n", item.getEmail());
                }
            }
            catch (IOException ex){
                System.out.println("Cannot open Contact.txt.%n");
            }
        }
        else{
            System.out.println("There is no list to be saved. Please add to the list before saving");
        }
    }

    public void loadFile(){
        try{
            Scanner reader = new Scanner(new File("Contact.txt"));

            while(reader.hasNext()){
                String firstName = reader.nextLine();
                String lastName = reader.nextLine();
                String phoneNumber = reader.nextLine();
                String email = reader.nextLine();

                ContactItem item = new ContactItem(firstName, lastName, phoneNumber, email);
                list.add(item);

            }
            System.out.println("Your file has been loaded.");
        }
        catch(NoSuchElementException ex){
            System.out.println("WARNING: Unable to save the list. Items cannot be found.");
        }
        catch(FileNotFoundException ex){
            System.out.println("WARNING: The file Contact.txt cannot be found");
        }
    }

    public void clearList(){
        list.clear();
    }

    public void viewList(){
        int counter = 0;
        for(ContactItem item : list){
            System.out.println("Contact " + counter);
            System.out.println("First Name: " + item.getFirstName());
            System.out.println("Last Name: " + item.getLastName());
            System.out.println("Phone Number: " + item.getPhoneNumber());
            System.out.println("E-mail: " + item.getEmail());
            System.out.println();
            counter ++;
        }
    }
}
