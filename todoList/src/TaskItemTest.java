import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        if(TaskItem.validateInputs("", "Description", "2020-11-11")){
            TaskItem a = new TaskItem("", "Description", "2020-11-11");
        }
        assertFalse();
    }


}