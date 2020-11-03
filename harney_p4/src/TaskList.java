import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    public static ArrayList <TaskItem> List = new ArrayList<>();

    public static void printToDoList(){
        int counter =0;
        for(TaskItem things : List){
            System.out.println(counter + ")" + " " + things.toString());
            counter ++;
        }
    }

    public static void addItemToList(){

        String tempTitle, tempDueDate, tempDescription;

        Scanner input = new Scanner(System.in);
        System.out.println("Task Title: ");
        tempTitle = input.nextLine();

        System.out.println("Task Description: ");
        tempDescription = input.nextLine();

        System.out.println("Task Due Date: ");
        tempDueDate = input.nextLine();

        TaskItem newItem = new TaskItem(tempTitle, tempDescription, tempDueDate);

        List.add(newItem);
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
}
