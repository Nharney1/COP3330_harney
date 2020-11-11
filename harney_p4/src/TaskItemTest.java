import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void settingTaskItemSucceedsWithValidTitle(){
        TaskItem item = new TaskItem();
        item.setTitle("This is the new title");
        assertEquals("This is the new title", item.getTitle());
    }

    @Test
    public void settingTaskItemFailsWithInvalidTitle(){
       assertThrows(IllegalArgumentException.class, ()-> {
           TaskItem item = new TaskItem();
           item.setTitle("");
       });
    }

    @Test
    public void settingDueDateSucceedsWithValidDate(){
        TaskItem item = new TaskItem();
        item.setDueDate("2020-11-03");
        assertEquals("2020-11-03", item.getDueDate());
    }

    @Test
    public void settingDueDateFailsWithInvalidDate(){
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem item = new TaskItem();
            item.setDueDate("0909_ab-28");
        });

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem item = new TaskItem();
        item.setTitle("New Item");
        item.setDescription("");
        item.setDueDate("2020-12-18");
        assertEquals("2020-12-18  New Item", item.toString());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem item = new TaskItem();
        item.setTitle("Valid Title");
        item.setDescription("new todo");
        item.setDueDate("2020-12-08");
        assertEquals("2020-12-08 new todo Valid Title", item.toString());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem item = new TaskItem();
            item.setTitle("New Item");
            item.setDescription("");
            item.setDueDate("sdfhb");
        });
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, ()-> {
            TaskItem item = new TaskItem();
            item.setTitle("");
            item.setDescription("");
            item.setDueDate("sdfhb");                   // If title fails the date will not need to be checked
        });
    }


}