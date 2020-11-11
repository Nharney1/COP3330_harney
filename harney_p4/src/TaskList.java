import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class TaskList {

    private static ArrayList<TaskItem> List = new ArrayList<>();

    public static void addItem(TaskItem newItem){
        List.add(newItem);
    }

    public static int getListSize(){
        return List.size();
    }

    public static void editItem(String title, String description, String dueDate, int index){
            List.get(index);

            //Ensures that none of the item details are changed when only 1 of the new inputs is bad
            //Will throw an error that App catches before changing any values already stored in the
            //Arraylist.
            TaskItem validationItem = new TaskItem();
            validationItem.setTitle(title);
            validationItem.setDescription(description);
            validationItem.setDueDate(dueDate);

            List.get(index).setTitle(title);
            List.get(index).setDescription(description);
            List.get(index).setDueDate(dueDate);

    }

    public static void removeItem(int index){
        try {
            List.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to delete does not exist.\n");
        }
    }

    public static String getDescription (int index){

            List.get(index);

            return List.get(index).getDescription();
    }

    public static String getDueDate (int index){
            List.get(index);

            return List.get(index).getDueDate();
    }

    public static String getTitle(int index){
            List.get(index);

            return List.get(index).getTitle();

    }

    public static boolean newTaskListIsEmpty(){
        if (getListSize() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void completeATask(int index){
            List.get(index).completeTask();

    }

    public static boolean getCompletionStatus(int index) {
        try{
            return List.get(index).getCompletionStatus();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to get the status of does not exist");
            return false;
        }
    }

    public static void unCompleteATask(int index){
            List.get(index).unCompleteTask();
    }

    public static void printListWithFormat(){
        int counter = 0;

        for(TaskItem item : List){
            if(item.getCompletionStatus()){
                System.out.print("*** ");
            }
                    System.out.println(counter + ") " + item.toString() + "\n");
            counter++;
        }
    }

    public static void saveListToFile() {
        try (
                Formatter output = new Formatter("ToDoList.txt")) {
            for (TaskItem item : List){
                output.format(item.getDueDate() + "," + item.getDescription() + "," + item.getTitle() + "\n");
            }
            System.out.println("List successfully saved to file.\n");
        } catch (
                IOException ex) {
            System.out.println("Cannot open the file.\n");
        }
    }

}