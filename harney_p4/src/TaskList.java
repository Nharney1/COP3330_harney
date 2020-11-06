import java.util.ArrayList;

public class TaskList {

    public static ArrayList<TaskItem> List = new ArrayList<>();

    public static void addItem(TaskItem newItem){
        List.add(newItem);
    }

    public static int getListSize(){
        return List.size();
    }

    public static void editItem(String title, String description, String dueDate, int index){
        try {
            List.get(index);
            List.get(index).setTitle(title);
            List.get(index).setDueDate(dueDate);
            List.get(index).setDescription(description);
        }
        catch(IndexOutOfBoundsException ex) {
            System.out.println("The indexed item you are trying to edit does not exist");
        }
         catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void removeItem(int index){
        try {
            List.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to delete does not exist");
        }
    }

    public static String getDescription (int index){
        try{
            List.get(index);

            return List.get(index).getDescription();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to retrieve does not exist");
            return ("The indexed item you are trying to retrieve does not exist");
        }
    }

    public static String getDueDate (int index){
        try{
            List.get(index);

            return List.get(index).getDueDate();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to retrieve does not exist");
            return ("The indexed item you are trying to retrieve does not exist");
        }
    }

    public static String getTitle(int index){
        try{
            List.get(index);

            return List.get(index).getTitle();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to retrieve does not exist");
            return ("The indexed item you are trying to retrieve does not exist");
        }
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
        try{
            List.get(index).completeTask();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to complete does not exist");
        }
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
        try{
            List.get(index).unCompleteTask();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("The indexed item you are trying to uncomplete does not exist");
        }
    }

    public static void printListWithFormat(){
        int counter = 0;

        for(TaskItem item : List){
            if(item.getCompletionStatus()){
                System.out.println("***");
            }
                        System.out.println(counter + ") " + item.toString() + "\n");
            counter++;
        }
    }


}