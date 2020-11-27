import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskItemTest {

    @Test
    public void constructorFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class, () -> {
            TaskItem a = new TaskItem("Item", "", "2020_01_09");
        });
    }

    @Test
    public void constructorFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, () -> {
            TaskItem a = new TaskItem("    ", " ", "2020-01-01");
        });
    }

    @Test
    public void constructorSucceedsWithValidDueDate(){
        TaskItem a = new TaskItem("Title", "Description", "2020-08-01");

        assertEquals("Title", a.getTitle());
        assertEquals("Description", a.getDescription());
        assertEquals("2020-08-01", a.getDueDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle(){
        TaskItem a = new TaskItem("A", "", "2020-09-09");

        assertEquals("A", a.getTitle());
        assertEquals("", a.getDescription());
        assertEquals("2020-09-09", a.getDueDate());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        a.updateToDoItem("New Title", "New Des", "2020-01-01");

        assertEquals("New Title", a.getTitle());
        assertEquals("New Des", a.getDescription());
        assertEquals("2020-01-01", a.getDueDate());
    }

    @Test
    public void editingDueDateFailsWithInvalidDate(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        assertThrows(IllegalArgumentException.class, () -> a.updateToDoItem("Title", " ", "2020-13-16"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        assertThrows(IllegalArgumentException.class, () -> a.updateToDoItem("Title", " ", "2020 12 16"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        a.updateToDoItem("Title", "Description", "2020-08-23");

        assertEquals("Title", a.getTitle());
        assertEquals("Description", a.getDescription());
        assertEquals("2020-08-23", a.getDueDate());

    }

    @Test
    public void editingTitleFailsWithEmptyString(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        assertThrows(IllegalArgumentException.class, () -> a.updateToDoItem("", " ", "2020-13-16"));
    }

    @Test
    public void editingTitleFailsWithWhiteSpacesOnly(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        assertThrows(IllegalArgumentException.class, () -> a.updateToDoItem("     ", " ", "2020-13-16"));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        a.updateToDoItem("Update", "Description", "2020-08-23");

        assertEquals("Update", a.getTitle());
        assertEquals("Description", a.getDescription());
        assertEquals("2020-08-23", a.getDueDate());

    }

    @Test
    public void completingItemSucceeds(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        a.completeItem();

        assertTrue(a.getCompletionStatus());
    }

    @Test
    public void unCompletingItemSucceeds(){
        TaskItem a = new TaskItem("Old Title", "Old Des", "2020-01-01");
        a.completeItem();

        assertTrue(a.getCompletionStatus());

        a.unCompleteItem();

        assertFalse(a.getCompletionStatus());
    }

}
