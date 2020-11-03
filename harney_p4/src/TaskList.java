import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    static int counter = 0;
    public static ArrayList <TaskItem> List = new ArrayList<>();

    public static void printToDoList(){
        int counter =0;
        for(TaskItem things : List){
            System.out.println(counter + ")" + " " + things.toString());
            counter ++;
        }
    }

    public static void addItemToList() {

        String tempTitle, tempDueDate, tempDescription;

        Scanner input = new Scanner(System.in);

        System.out.println("Task Title: ");
        tempTitle = input.nextLine();

        System.out.println("Task Description: ");
        tempDescription = input.nextLine();

        System.out.println("Task Due Date: ");
        tempDueDate = input.nextLine();

        checkAddedItems(tempTitle, tempDescription, tempDueDate);



    }

    public static void checkAddedItems(String tempTitle, String tempDescription, String tempDueDate) {
        try{
            if(!TaskItem.verifyTitle(tempTitle)){
                throw new Exception("Error: Invalid Title");
            }
            if(!TaskItem.verifyDueDate(tempDueDate)){
                throw new IllegalArgumentException("Error: Invalid Due Date");
            }
            else{
                TaskItem newItem = new TaskItem(tempTitle, tempDescription, tempDueDate);
                List.add(newItem);
                counter ++;
            }
        }

        catch (IllegalArgumentException e){
            System.out.println("ERROR: Invalid due date, item not added to list");
            }
        catch(Exception e){
            System.out.println("ERROR: Invalid title, item not added to list");
        }


    }

    public static void removeItem(){
        printToDoList();

        System.out.println("What item would you like to remove?");

        Scanner input = new Scanner(System.in);
        int deletionNumber = input.nextInt();
        input.nextLine();

        List.remove(deletionNumber);

        printToDoList();

    }

    public static void getItemToEdit(){

        int indexToEdit;

        System.out.println("What item would you like to edit?");
        printToDoList();

        Scanner input = new Scanner(System.in);
        indexToEdit = input.nextInt();
        input.nextLine();

        editItem(indexToEdit);
    }

    public static void editItem(int itemIndex){

        String tempTitle, tempDueDate, tempDescription;

        Scanner input = new Scanner(System.in);

        System.out.println("Task Title: ");
        tempTitle = input.nextLine();

        System.out.println("Task Description: ");
        tempDescription = input.nextLine();

        System.out.println("Task Due Date: ");
        tempDueDate = input.nextLine();

        checkEditedItem(tempTitle, tempDescription, tempDueDate, itemIndex);

    }

    public static void checkEditedItem(String tempTitle, String tempDescription, String tempDueDate, int itemIndex){
        try{
            if(!TaskItem.verifyTitle(tempTitle)){
                throw new Exception("Error: Invalid Title");
            }
            if(!TaskItem.verifyDueDate(tempDueDate)){
                throw new IllegalArgumentException("Error: Invalid Due Date");
            }
            else{
                List.get(itemIndex).setTitle(tempTitle);
                List.get(itemIndex).setDescription(tempDescription);
                List.get(itemIndex).setDueDate(tempDueDate);

            }
        }

        catch (IllegalArgumentException e){
            System.out.println("ERROR: Invalid due date, item not added to list");
        }
        catch(Exception e){
            System.out.println("ERROR: Invalid title, item not added to list");
        }


    }

    public static int getCounter(){
        return counter;
    }
}
