public class TaskItem {

    private String title;
    private String description;
    private String dueDate;

    public TaskItem(String title, String description, String dueDate){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public static boolean validateInputs(String title, String description, String dueDate){
        try{
            if(!validateTitle(title)){
                throw new IllegalArgumentException();
            }
            if (!validateDueDate(dueDate)){
                throw new IllegalAccessException();
            }
            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println("ERROR: Invalid Title");
            return false;
        }
        catch(IllegalAccessException e){
            System.out.println("ERROR: Invalid Due Date");
            return false;
        }
    }

    public static boolean validateTitle(String title){
        if (title.length() >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean validateDueDate(String dueDate){
        boolean isFormatTrue = true;

        if (dueDate.length() != 10) {
            return false;
        }
        else {
            isFormatTrue = dueDateChecker(dueDate);

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
}
