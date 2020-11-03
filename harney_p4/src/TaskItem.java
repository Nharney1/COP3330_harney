public class TaskItem {

    private String title;
    private String description;
    private String dueDate;

    public TaskItem(String inputTitle, String inputDescription, String inputDueDate) {
        title = inputTitle;
        description = inputDescription;
        dueDate = inputDueDate;
    }

    public void setTitle(String inputTitle) {
        title = inputTitle;
    }

    public String getTitle() {
        return title;
    }

    public static boolean verifyTitle(String inputTitle){
        if (inputTitle.length() >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setDescription(String inputDescription) {
        description = inputDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDueDate(String inputDueDate) {
        dueDate = inputDueDate;

    }

    public String getDueDate(){
        return dueDate;
    }

    public static boolean verifyDueDate(String inputDueDate){
        boolean isFormatTrue = true;

        if (inputDueDate.length() != 10) {
            return false;
        }
        else {
            isFormatTrue = dueDateChecker(inputDueDate);

            return isFormatTrue;
        }
    }

    public static boolean dueDateChecker(String dueDate) {

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

    @Override
    public String toString(){
        return ("[" + getDueDate() + "]" + " " + getDescription() + " " + getTitle() + "\n");
    }
}