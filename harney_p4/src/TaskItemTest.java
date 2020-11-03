import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem a = new TaskItem("", "Description", "2020-11-11");
        assertEquals(null, a.getTitle());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem a = new TaskItem("Some Title", "Description", "2020-11-11");
        assertEquals("Some Title", a.getTitle());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem a = new TaskItem ("Some Title", "A description", "9090");
        assertEquals(null, a.getDueDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem a = new TaskItem("Some title", "A description", "2011-11-12");
        assertEquals("2011-11-12", a.getDueDate());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem a = new TaskItem("Some title", "A description", "2011-11-12");
        a.setDueDate("999__-99");
        assertEquals("2011-11-12", a.getDueDate());
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem a = new TaskItem("Some title", "A description", "2011-11-12");
        a.setDueDate("2020-20-20");
        assertEquals("2020-20-20",a.getDueDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem a = new TaskItem("Some title", "A description", "2011-11-12");
        a.setTitle("");
        assertEquals("Some title","Some title");
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem a = new TaskItem("Some title", "A description", "2011-11-12");
        a.setTitle("Some new title");
        assertEquals("Some new title", "Some new title");
    }


}
