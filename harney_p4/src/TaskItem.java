import java.util.Scanner;

public class TaskItem {

    private String title;
    private String description;
    private String dueDate;

    public TaskItem(String inputTitle, String inputDescription, String inputDueDate) {
        setTitle(inputTitle);
        description = inputDescription;
        setDueDate(inputDueDate);
    }

    public void setTitle(String inputTitle) {
        if (inputTitle.length() >= 1) {
            title = inputTitle;
        } else {
            System.out.println("WARNING: Invalid title; must be at least 1 character long; task not created");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String inputDescription) {
        description = inputDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDueDate(String inputDueDate) {

        boolean isFormatTrue = true;

        if (inputDueDate.length() != 10){
            System.out.println("WARNING: Invalid due date; task not created");
        }
        else {
            isFormatTrue = dueDateChecker(inputDueDate);

            if (isFormatTrue) {
                dueDate = inputDueDate;
            } else {
                System.out.println("WARNING: Invalid due date; task not created");
            }
        }
    }

    public boolean dueDateChecker(String dueDate) {

        int counter = 0;
        boolean isFormatCorrect = true;

        while (counter <= 9) {
            if (counter == 4 || counter == 7) {
                if (!(dueDate.charAt(counter) == '-')) {
                    isFormatCorrect = false;
                }
            } else {
                if (!Character.isDigit(dueDate.charAt(counter))) {
                    isFormatCorrect = false;
                }
            }
            counter++;
        }
        return isFormatCorrect;
    }

    public String getDueDate(){
        return dueDate;
    }

    @Override
    public String toString(){
        return ("[" + getDueDate() + "]" + " " + getDescription() + " " + getTitle() + "\n");
    }
}