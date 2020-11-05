import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {

    private String title;
    private String description;
    private String dueDate;
    private boolean completed = false;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if (title.length() <1){
            throw new IllegalArgumentException("Title must be at least one character");
        }

        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDueDate(){
        return dueDate;
    }

    public void setDueDate(String dueDate){
        if (dateValidation(dueDate)){
            this.dueDate = dueDate;
        }
        else {
            throw new IllegalArgumentException("Please use a valid date format");
        }
    }

    private boolean dateValidation(String dueDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tempDate = null;
        dateFormat.setLenient(false);

        try {
            tempDate = dateFormat.parse(dueDate);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public String toString(){
        return ("Due Date "  + getDueDate()  + " Description " + getDescription() + " Title " + getTitle() );
    }

    public boolean getCompletionStatus(){
        return completed;
    }

    public void completeTask(){
        completed = true;
    }

    public void unCompleteTask(){
        completed = false;
    }
}