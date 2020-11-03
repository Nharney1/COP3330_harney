import java.util.Scanner;

public class TaskItem {

    private String title;
    private String description;
    private String dueDate;

    public TaskItem(String inputTitle, String inputDescription, String inputDueDate) {
        title = setTitle(inputTitle);
        description = inputDescription;
        dueDate = setDueDate(inputDueDate);
    }



    public String setTitle(String inputTitle) {
        if (inputTitle.length() >= 1) {
            return inputTitle;
        } else {
            return "ERROR";
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

    public String setDueDate(String inputDueDate) {

        boolean isFormatTrue = true;

        if (inputDueDate.length() != 10){
            return "ERROR";
        }
        else {
            isFormatTrue = dueDateChecker(inputDueDate);

            if (isFormatTrue) {
                return inputDueDate;
            } else {
                return "ERROR";
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
}