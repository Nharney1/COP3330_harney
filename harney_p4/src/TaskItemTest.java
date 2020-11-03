import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem a = new TaskItem("", "Description", "2020-11-11");
        assertEquals("ERROR", a.getTitle());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem a = new TaskItem("Some Title", "Description", "2020-11-11");
        assertEquals("Some Title", a.getTitle());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem a = new TaskItem ("Some Title", "A description", "2020-00-10");
        assertEquals("ERROR", a.setDueDate("6969"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem a = new TaskItem("Some title", "A description", "2011-11-12");
        assertEquals("2020-12-09", a.setDueDate("2020-12-09"));
    }
}
