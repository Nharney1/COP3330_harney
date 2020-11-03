import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem a = new TaskItem("", "Description", "2020-11-11");
        TaskList.checkAddedItems(" 1", "", "0000-00-00" );
        TaskList.checkAddedItems(" 2", "", "0110-00" );             //Invalid due date not counted
        TaskList.checkAddedItems(" 3", "", "0000-00-10" );
        assertEquals(2, TaskList.getCounter());

    }


}