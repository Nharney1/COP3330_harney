import java.time.LocalDate;

public class TaskItem extends Item {

    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;


    public TaskItem(String title, String description, String dueDate){
        if(title.isBlank()){
            throw new IllegalArgumentException("WARNING: Titles must be at least one character long.");
        }

        LocalDate date;
        try{
            date = LocalDate.parse(dueDate);
        }
        catch(java.time.format.DateTimeParseException ex){
            throw new IllegalArgumentException("WARNING: Please enter a valid date: yyyy-mm-dd .");
        }

        this.title = title;
        this.description = description;
        this.dueDate = date;
        this.completed = false;
    }

    public void updateToDoItem(String title, String description, String dueDate){
        if(title.isBlank()){
            throw new IllegalArgumentException("WARNING: Titles must be at least one character long, item not edited.");
        }

        LocalDate date;
        try{
            date = LocalDate.parse(dueDate);
        }
        catch(java.time.format.DateTimeParseException ex){
            throw new IllegalArgumentException("WARNING: Please enter a valid date: yyyy-mm-dd . Item not edited.");
        }
        this.title = title;
        this.description = description;
        this.dueDate = date;
        this.completed = false;

    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDueDate(){
        return dueDate.toString();
    }

    @Override
    public String toString(){
        return ( getDueDate() + " " + getTitle() + " " + getDescription());
    }

    public boolean getCompletionStatus(){
        return this.completed;
    }

    public void completeItem(){
        this.completed = true;
    }

    public void unCompleteItem(){
        this.completed = false;
    }

}
