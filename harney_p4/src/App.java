import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main (String[] args){

        boolean starter = true;

        startupProcess();

        while( starter) {
            createNewList();
        }
    }

    public static void startupProcess(){
        printStartingMenu();
        processInitialUserInput(getInitialUserRequest());
    }

    public static void printStartingMenu(){

        System.out.println("Main Menu");
        System.out.println("---------\n\n");
        printStartingMenuOptions();
    }

    public static void printStartingMenuOptions(){
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

    public static String getInitialUserRequest(){

        Scanner input = new Scanner(System.in);

        String InitialUserInput;
        InitialUserInput = input.next();

        input.nextLine();

        return InitialUserInput;
    }

    public static void processInitialUserInput (String Input){
        if (Input.equals("1")){
            createNewList();
        }
        else if (Input.equals("2")){
            loadNewList();
        }
        else{
            System.exit(0);
        }
    }

    public static void createNewList(){
        printOperationMenu();
        processOperationMenuInput(getOperationMenuInput());
    }

    public static void loadNewList(){
        System.out.println("List Loaded");
    }

    public static void printOperationMenu(){
        System.out.println("List Operation Menu\n\n");
        System.out.println("--------------------");
        System.out.println("1) View the list");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as completed");
        System.out.println("6) Unmark an item as completed");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }

    public static String getOperationMenuInput(){

        String operationMenuInput = null;

        Scanner input = new Scanner(System.in);

        operationMenuInput = input.next();
        input.nextLine();

        return operationMenuInput;

    }

    public static void processOperationMenuInput(String input){
        switch (input) {
            case "1" -> TaskList.printToDoList();
            case "2" -> TaskList.addItemToList();
            case "3" -> TaskList.getItemToEdit();
            case "4" -> TaskList.removeItem();
            case "5" -> System.out.print("marking an item as complete");
            case "6" -> System.out.println("unmarking an item as complete");
            case "7" -> System.out.println("saving the current list");
            default ->  startupProcess();
        }
    }

}

