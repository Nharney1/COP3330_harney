import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp extends App {

    private static final Scanner input = new Scanner(System.in);

    private ContactList contactList = new ContactList();



    public void Menu(){
        mainMenu();
        while(true){
            operationMenu();
        }
    }

    private void mainMenu(){
        printMainMenu();
        String initialInput = getMainMenuInput();
        actOnMainMenuInput(initialInput);
    }

    private void operationMenu(){
        printOperationMenu();
        String userInput = getOperationMenuInput();
        actOnOperationMenuInput(userInput);
    }

    private void printMainMenu(){
        System.out.println();
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

    private String getMainMenuInput(){
        System.out.print(">");
        return input.nextLine();
    }

    private void actOnMainMenuInput(String input){
        switch (input){
            case "1" -> operationMenu();
            case "2" -> contactList.loadFile();
            case "3" -> System.exit(0);
            default -> invalidMainMenuInput();
        }
    }

    private static void printOperationMenu(){
        System.out.println();
        System.out.println("1) View the list");
        System.out.println("2) Add a contact");
        System.out.println("3) Edit a contact");
        System.out.println("4) Remove a contact");
        System.out.println("5) Save the current list");
        System.out.println("6) Quit to the main menu");
        System.out.println();
    }

    private String getOperationMenuInput(){
        System.out.print(">");
        return input.nextLine();
    }

    private void actOnOperationMenuInput(String userInput){
        switch(userInput){
            case "1" -> printTheList();
            case "2" -> addItem();
            case "3" -> editItem();
            case "4" -> deleteItem();
            case "5" -> saveList();
            case "6" -> resetList();
            default -> System.out.println("You did not enter a valid option. Please try again.\n");

        }
    }

    private void invalidMainMenuInput(){
        System.out.println("ERROR: Please enter a valid option.");
        Menu();
    }

    private void resetList(){
        contactList.clearList();
        Menu();
    }



    private void printTheList(){
        if(contactList.isEmpty()){
            System.out.println("The list is empty. Please add items.\n");
        }
        else {
            contactList.viewList();
        }
    }

    private void addItem(){
        try{
            String firstName = getFirstName();
            String lastName = getLastName();
            String phoneNumber = getPhoneNumber();
            String email = getEmail();

            ContactItem item = new ContactItem(firstName, lastName, phoneNumber, email);
            contactList.add(item);
            System.out.println("Item added successfully.");
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void editItem(){
        try{
            if(contactList.isEmpty()){
                System.out.println("The list is empty. There are no items to edit");
            }
            else{
                contactList.viewList();
                System.out.println();

                int index = getIndex();
                verifyIndex(index);

                String firstName = getFirstName();
                String lastName = getLastName();
                String phoneNumber = getPhoneNumber();
                String email = getEmail();

                contactList.editItem(firstName, lastName, phoneNumber, email, index);
                System.out.println("Your item has been successfully updated.");
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }catch (InputMismatchException ex){
            System.out.println("ERROR: Please enter your option as a digit.\n");
            input.nextLine();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The item you are trying to edit does not exist.\n");
        }
    }

    private void deleteItem(){
        try {
            if(contactList.isEmpty()){
                System.out.println("The list is empty. There are no items to delete.\n");
            }
            else{
                contactList.viewList();
                System.out.println();

                System.out.println("Which item number would you like to delete");
                int index = input.nextInt();
                input.nextLine();

                contactList.delete(index);
                System.out.println("Item deleted");
            }
        } catch(InputMismatchException ex){
            System.out.println("ERROR: Please enter the item you want to delete as a digit.\n");
            input.nextLine();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The item you are trying to delete does not exist.\n");
        }
    }

    private void saveList(){
        if(contactList.size() >0){
            contactList.saveFile();
            System.out.println("List saved to Contact.txt .");
        }
        else {
            System.out.println("List not saved. Please add to the list before saving.");
        }
    }


    private String getFirstName(){
        System.out.print("Please enter a first name > ");
        return input.nextLine();
    }

    private String getLastName(){
        System.out.print("Please enter a last name > ");
        return input.nextLine();
    }

    private String getPhoneNumber(){
        System.out.print("Please enter a phone number (xxx-xxx-xxxx) > ");
        return input.nextLine();
    }

    private String getEmail(){
        System.out.print("Please enter an e-mail address (x@y.z) > ");
        return input.nextLine();
    }

    private int getIndex(){
        System.out.println("Which contact number would you like to edit?");
        int index = input.nextInt();
        input.nextLine();
        return index;
    }

    private void verifyIndex(int index){
        if (index > contactList.size()-1){
            throw new IndexOutOfBoundsException();
        }
    }

}
