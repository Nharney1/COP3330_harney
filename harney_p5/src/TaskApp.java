import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {

    private static final Scanner input = new Scanner(System.in);

    private TaskList taskList = new TaskList();



    public void Menu(){
        mainMenu();
        while(true) {
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
            case "2" -> taskList.loadFile();
            case "3" -> System.exit(0);
            default -> invalidMainMenuInput();
        }
    }

    private void printOperationMenu(){
        System.out.println();
        System.out.println("1) View the list");
        System.out.println("2) Add an item to the list");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as complete");
        System.out.println("6) Unmark an item as complete");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
        System.out.println();
    }

    private String getOperationMenuInput(){
        System.out.print(">");
        return input.nextLine();
    }

    private void actOnOperationMenuInput(String userInput){
        switch (userInput) {
            case "1" -> printTheList();
            case "2" -> addItem();
            case "3" -> editItem();
            case "4" -> deleteItem();
            case "5" -> completeItem();
            case "6" -> unCompleteItem();
            case "7" -> saveList();
            case "8" -> resetList();
            default -> System.out.println("You did not enter a valid option. Please try again.\n");
        }
    }

    private void invalidMainMenuInput(){
        System.out.println("ERROR: Please enter a valid option.");
        Menu();
    }

    private void resetList (){
        taskList.clearList();
        Menu();
    }



    private void printTheList(){
        if(taskList.isEmpty()){
            System.out.println("The list is empty. Please add items.\n");
        }
        else{
            taskList.viewList();
        }
    }

    private void addItem (){
        try {
            String title = getTitleInput();
            String description = getDescriptionInput();
            String dueDate = getDueDateInput();
            TaskItem item = new TaskItem(title, description, dueDate);
            taskList.add(item);
            System.out.println("Item added successfully.");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void editItem(){
        try {
            if(taskList.isEmpty()){
                System.out.println("The list is empty. There are no items to edit");
            }
            else {
                taskList.viewList();
                System.out.println();

                int index = getIndex();
                verifyIndex(index);
                String title = getTitleInput();
                String description = getDescriptionInput();
                String dueDate = getDueDateInput();

                taskList.editItem(title, description, dueDate, index);
                System.out.println("Your item has been successfully updated.");

            }
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        catch (InputMismatchException ex){
            System.out.println("ERROR: Please enter your option as a digit.\n");
            input.nextLine();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The item you are trying to edit does not exist.\n");
        }
    }

    private void deleteItem(){
        try{
            if(taskList.isEmpty()){
                System.out.println("The list is empty. There are no items to delete.\n");
            }
            else{
                taskList.viewList();
                System.out.println();

                System.out.println("Which item number would you like to delete");
                int index = input.nextInt();
                input.nextLine();

                taskList.delete(index);
                System.out.println("Item deleted");
            }
        }catch(InputMismatchException ex){
            System.out.println("ERROR: Please enter the item you want to delete as a digit.\n");
            input.nextLine();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The item you are trying to delete does not exist.\n");
        }
    }

    private void completeItem(){
        try{
            if(taskList.isEmpty()){
                System.out.println("There are no items to complete. The list is empty.\n");
            }
            else{
                taskList.viewList();
                System.out.println();

                System.out.println("Which item number would you like to complete?");
                int index = input.nextInt();
                input.nextLine();

                if (index + 1 <= taskList.size()){
                    taskList.completeItem(index);
                    System.out.println("Item marked as complete.\n");
                }
                else{
                    System.out.println("The item you are trying to complete does not exist.\n");
                }
            }
        } catch (InputMismatchException ex){
            System.out.println("ERROR: Please enter the item you want to complete as a digit.\n");
            input.nextLine();
        }
    }

    private void unCompleteItem(){
        try{
            if(taskList.isEmpty()){
                System.out.println("There are no items to mark as not complete. The list is empty.\n");
            }
            else{
                taskList.viewList();
                System.out.println();

                System.out.println("Which item number would you like to mark as not complete?");
                int index = input.nextInt();
                input.nextLine();

                if (index + 1 <= taskList.size()){
                    taskList.unCompleteItem(index);
                    System.out.println("Item marked as not complete.\n");
                }
                else{
                    System.out.println("The item you are trying to mark as not complete does not exist.\n");
                }
            }
        } catch (InputMismatchException ex){
            System.out.println("ERROR: Please enter the item you want to mark as not complete as a digit.\n");
            input.nextLine();
        }
    }

    private void saveList(){
        if(taskList.size()>0) {
            taskList.saveFile();
            System.out.println("List saved to ToDo.txt .");
        }
        else {
            System.out.println("List not saved. Please add to the list before saving.");
        }
    }




    private String getTitleInput(){
        System.out.print("Please enter a title > ");
        return input.nextLine();
    }

    private String getDescriptionInput(){
        System.out.print("Please enter a description > ");
        return input.nextLine();
    }

    private String getDueDateInput(){
        System.out.print("Please enter a due date > ");
        return input.nextLine();
    }

    private int getIndex(){
        System.out.println("Which item number would you like to edit?");
        int index = input.nextInt();
        input.nextLine();
        return index;
    }

    private void verifyIndex(int index){
        if (index > taskList.size()-1){
            throw new IndexOutOfBoundsException();
        }
    }


}
