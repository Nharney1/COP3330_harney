import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TaskList  {

    private List<TaskItem> list = new ArrayList<>();


    public TaskItem get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void add(TaskItem item){
        list.add(item);
    }

    public void editItem(String title, String description, String dueDate, int index){
        if(index > list.size()-1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to edit does not exist.%n");
        }
        else {
            list.get(index).updateToDoItem(title, description, dueDate);
        }
    }

    public void delete(int index){
        if (index > list.size() -1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to delete does not exist. %n");
        }
        else {
            list.remove(index);
        }
    }



    public void completeItem(int index){
        if (index > list.size() -1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to complete does not exist. %n");
        }
        else {
            list.get(index).completeItem();
        }
    }

    public void unCompleteItem(int index){
        if (index > list.size() -1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to uncomplete does not exist. %n");
        }
        else {
            list.get(index).unCompleteItem();
        }

    }

    public boolean getItemStatus(int index){
        if (index > list.size() -1){
            throw new IndexOutOfBoundsException("WARNING: The item you are trying to get the status of does not exist. %n");
        }
        else {
            return list.get(index).getCompletionStatus();
        }

    }

    public void saveFile(){
        if(list.size() > 0){
            try (Formatter output = new Formatter("ToDo.txt")){
                for(TaskItem item : list){
                    output.format("%s%n", item.getDueDate());
                    output.format("%s%n", item.getTitle());
                    output.format("%s%n", item.getDescription());
                    if(item.getCompletionStatus()) {
                        output.format("%s%n", "Completed");
                    }
                    else {
                        output.format("%s%n", "Not Completed");
                    }
                }
            }
            catch (IOException ex){
                System.out.println("Cannot open ToDo.txt.%n");
            }
        }
        else {
            System.out.println("There is no list to be saved. Please add to the list before saving.");
        }
    }

    public void loadFile(){
        try {
            Scanner reader = new Scanner(new File("ToDo.txt"));

            int counter = 0;
            while(reader.hasNext()){
                String dueDate = reader.nextLine();
                String title = reader.nextLine();
                String description = reader.nextLine();
                String completed = reader.nextLine();

                TaskItem item = new TaskItem(title, description, dueDate);
                list.add(item);

                if(completed.equals("Completed")){
                    completeItem(counter);
                }
                counter++;
            }
            System.out.println("Your file has been loaded.");
        }
        catch (NoSuchElementException ex){
            System.out.println("WARNING: Unable to save the list. Items cannot be found");
        }
        catch(FileNotFoundException ex){
            System.out.println("WARNING: The file ToDo.txt cannot be found");
        }

    }

    public void viewList(){
        int counter = 0;

        for(TaskItem item : list){
            if(item.getCompletionStatus()){
                System.out.print("*** ");
            }
            System.out.println(counter + ") " + item.toString());
            counter++;
        }
    }

    public void clearList(){
        list.clear();
    }

}
