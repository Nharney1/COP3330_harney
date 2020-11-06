import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        mainMenu();

        while(true){
            operationMenu();
        }

    }

    private static void printMainMenu(){
        System.out.println("Main Menu");
        System.out.println("_________\n");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.print("3) Quit\n\n");
    }

    private static String getMainMenuInput(){

        Scanner input = new Scanner(System.in);
        String userInput = input.next();
        input.nextLine();

        return userInput;
    }

    private static void actOnMainMenuInput(String userInput){
        try{
            if(userInput.equals("1")){
                operationMenu();
            }
            else if (userInput.equals("2")){
                System.out.println("load an existing list");
            }
            else if (userInput.equals("3")){
                System.exit(0);
            }
            else {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException ex){
            System.out.println("Please enter a valid selection for the main menu options\n\n");
            mainMenu();
        }

    }

    private static void mainMenu(){
        String userInput = null;

        printMainMenu();
        userInput = getMainMenuInput();
        actOnMainMenuInput(userInput);

    }

    private static void printOperationMenu(){
        System.out.println("1) View the list");
        System.out.println("2) Add an item to the list");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as complete");
        System.out.println("6) Unmark an item as complete");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }

    private static String getOperationMenuInput(){

        String userInput;

        Scanner input = new Scanner(System.in);
        userInput = input.next();
        input.nextLine();

        return userInput;
    }

    private static void actOnOperationMenuInput(String userInput){

        switch (userInput) {
            case "1" -> printTheList();
            case "2" -> getItemToAddItemToList();
            case "3" -> getItemToEdit();
            case "4" -> System.out.println("Remove an item\n");
            case "5" -> System.out.println("Mark an item as complete\n");
            case "6" -> System.out.println("Unmark an item as complete\n");
            case "7" -> System.out.println("Save the current list\n");
            case "8" -> mainMenu();
            default -> System.out.println("You did not enter a valid option. Please try again\n");
        }
    }




    private static void printTheList(){
        TaskList.printListWithFormat();
    }

    private static void operationMenu(){

        String userInput;

        printOperationMenu();
        userInput = getOperationMenuInput();
        actOnOperationMenuInput(userInput);
    }

    private static void getItemToAddItemToList(){

        Scanner input = new Scanner(System.in);

        String tempTitle, tempDescription, tempDueDate;

        System.out.println("Please enter a title");
        tempTitle = input.nextLine();

        System.out.println("Please enter a description");
        tempDescription = input.nextLine();

        System.out.println("Please enter a due date");
        tempDueDate = input.nextLine();

        addItemToList(tempTitle, tempDescription, tempDueDate);



    }

    private static void addItemToList(String tempTitle, String tempDescription, String tempDueDate){
        try {
            TaskItem item = new TaskItem();
            item.setTitle(tempTitle);
            item.setDescription(tempDescription);
            item.setDueDate(tempDueDate);
            TaskList.addItem(item);
            System.out.println("Item was created successfully\n\n");
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    private static void getItemToEdit(){

        TaskList.printListWithFormat();

        Scanner input = new Scanner(System.in);

        String tempTitle, tempDescription, tempDueDate;
        int index;

        System.out.println("Which item number would you like to edit");
        index = input.nextInt();
        input.nextLine();

        System.out.println("Please enter a title");
        tempTitle = input.nextLine();

        System.out.println("Please enter a description");
        tempDescription = input.nextLine();

        System.out.println("Please enter a due date");
        tempDueDate = input.nextLine();

        editItem(tempTitle, tempDescription, tempDueDate, index);

    }

    private static void editItem(String tempTitle, String tempDescription, String tempDueDate, int index){
        try {
            TaskList.editItem(tempTitle, tempDescription, tempDueDate, index);
            System.out.println("The item has been edited successfully\n");
        }
        catch (IndexOutOfBoundsException ex){
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}


