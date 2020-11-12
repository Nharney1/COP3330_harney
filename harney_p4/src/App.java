import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
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
            switch (userInput) {
                case "1" -> operationMenu();
                case "2" -> readItemsFromFile();
                case "3" -> System.exit(0);
                default -> throw new IllegalArgumentException();
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
            case "4" -> deleteItem();
            case "5" -> completeItem();
            case "6" -> unCompleteItem();
            case "7" -> saveList();
            case "8" -> mainMenu();
            default -> System.out.println("You did not enter a valid option. Please try again.\n");
        }
    }



    private static void printTheList(){
        if(TaskList.newTaskListIsEmpty()){
            System.out.println("The list is empty. Please add items.\n");
        }
        else{
            TaskList.printListWithFormat();
        }
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

        tempTitle = getTitleInput();
        tempDescription = getDescriptionInput();
        tempDueDate = getDueDateInput();

        addItemToList(tempTitle, tempDescription, tempDueDate);

    }

    public static void addItemToList(String tempTitle, String tempDescription, String tempDueDate){
        try {
            TaskItem item = new TaskItem();
            item.setTitle(tempTitle);
            item.setDescription(tempDescription);
            item.setDueDate(tempDueDate);
            TaskList.addItem(item);
            System.out.println("Item was created successfully.\n\n");
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

    private static void getItemToEdit(){
        try {

            if(TaskList.newTaskListIsEmpty()){
                System.out.println("The list is empty. There are no items to edit.\n");
            }
            else {
                TaskList.printListWithFormat();

                String tempTitle, tempDescription, tempDueDate;
                int index;

                index = getIndexInput();
                tempTitle = getTitleInput();
                tempDescription = getDescriptionInput();
                tempDueDate = getDueDateInput();

                editItem(tempTitle, tempDescription, tempDueDate, index);
            }
        } catch (InputMismatchException ex){
            System.out.println("ERROR: Please enter your option as a digit.\n");
        }
    }

    private static void editItem(String tempTitle, String tempDescription, String tempDueDate, int index){
        try {
            TaskList.editItem(tempTitle, tempDescription, tempDueDate, index);
            System.out.println("The item has been edited successfully\n");
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("The item you are trying to edit does not exist.\n");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void deleteItem(){

        try {
            if(TaskList.newTaskListIsEmpty()){
                System.out.println("The list is empty. There are no items to delete.\n");
            }
            else {

                TaskList.printListWithFormat();

                Scanner input = new Scanner(System.in);

                int index;

                System.out.println("Which item number would you like to delete");
                index = input.nextInt();
                input.nextLine();

                TaskList.removeItem(index);
            }
        } catch (InputMismatchException ex){
            System.out.println("ERROR: Please enter the item you want to delete as a digit.\n");
        }

    }

    private static void completeItem(){
      try {

          if (TaskList.newTaskListIsEmpty()){
              System.out.println("There are no items to complete. The list is empty.\n");
          }
          else {
              TaskList.printListWithFormat();

              Scanner input = new Scanner(System.in);

              int index;

              System.out.println("Which item number would you like to complete");
              index = input.nextInt();
              input.nextLine();

              if (index+1 <= TaskList.getListSize()) {
                  TaskList.completeATask(index);

                  System.out.println("Item marked as complete\n");
              }
              else {
                  System.out.println("The item you are trying to complete does not exist.\n");
              }
          }
      }
      catch(InputMismatchException ex){
          System.out.println("ERROR: Please enter the item you want to complete as a digit.\n");
      }
    }

    private static void unCompleteItem(){
        try {

            if (TaskList.newTaskListIsEmpty()) {
                System.out.println("There are no items to uncomplete. The list is empty.\n");
            } else {
                TaskList.printListWithFormat();

                Scanner input = new Scanner(System.in);

                int index;

                System.out.println("Which item number would you like to complete");
                index = input.nextInt();
                input.nextLine();
        if(index+1 <= TaskList.getListSize()) {
            TaskList.unCompleteATask(index);

            System.out.println("Item unmarked as complete\n");
        }
        else {
            System.out.println("The item you are trying to unmark as complete does not exist.\n");
        }
            }
        }
        catch(InputMismatchException ex){
            System.out.println("ERROR: Please enter the item you want to uncomplete as a digit.\n");
        }
    }

    private static void saveList() {
        TaskList.saveListToFile();
    }

    public static void readItemsFromFile(){

        Scanner reader;

        try{
            reader = new Scanner (new File("ToDoList.txt"));
            reader.useDelimiter(";|\\n");


            while(reader.hasNextLine()) {

                String tempDueDate = reader.next();
                String tempDescription = reader.next();
                String tempTitle = reader.next();

                addItemToList(tempTitle, tempDescription, tempDueDate);

            }
        }

        catch(NoSuchElementException ex){
            //Exception for writing to files
        }
        catch(FileNotFoundException ex){
            System.out.println("WARNING: Cannot find the file you have.\n");
        }
       catch (Exception ex){
            System.out.println("WARNING: Issue opening the file.\n");
        }
    }

    private static String getTitleInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a title:");
        return input.nextLine();
    }

    private static String getDescriptionInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a description:");
        return input.nextLine();
    }

    private static String getDueDateInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a due date:");
        return input.nextLine();
    }

    private static int getIndexInput(){
        Scanner input = new Scanner(System.in);

        System.out.println("Which item number would you like to edit?");
        int index = input.nextInt();
        input.nextLine();
        return index;
    }
}


