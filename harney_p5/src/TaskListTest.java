import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskListTest {

    @Test
    public void addingItemsIncreasesSize(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        assertEquals(itemList.size(), 1);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        itemList.completeItem(0);
        assertTrue(itemList.get(0).getCompletionStatus());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.completeItem(2));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.editItem("New Title", "Des", "2020-03-03", 4));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        TaskItem item2 = new TaskItem("Item 2", "2", "2022-11-11");
        itemList.add(item);
        itemList.add(item2);
        itemList.editItem("New Title", "New Description", "2020-03-03", 1);

        assertEquals("New Description", itemList.get(1).getDescription());
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        itemList.editItem("New Title", "New Description", "2020-02-02",0 );

        assertEquals("2020-02-02", itemList.get(0).getDueDate());
    }

    @Test
    public void editingItemDueDateFailsWithInvalidDateFormat(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IllegalArgumentException.class, ()-> itemList.editItem("New Title", "New Description", "2020.02.02",0 ));
    }

    @Test
    public void editingItemDueDateFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.editItem("New Title", "New Description", "2020.02.02",28 ));
    }

    @Test
    public void editingItemDueDateFailsWithInvalidDate(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IllegalArgumentException.class, ()-> itemList.editItem("New Title", "New Description", "2020-22-02",0 ));
    }

    @Test
    public void editingItemTitleFailsWithInvalidString(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IllegalArgumentException.class, ()-> itemList.editItem("    ", "New Description", "2020-22-02",0 ));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.editItem("New Title", "New Description", "2020-02-02",2));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        itemList.editItem("New Title", "New Description", "2020-02-02",0);

        assertEquals("New Title", itemList.get(0).getTitle());
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.get(2).getDescription());
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertEquals("None", itemList.get(0).getDescription());
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.get(2).getDueDate());
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertEquals("2022-11-11", itemList.get(0).getDueDate());
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, ()-> itemList.get(2).getTitle());
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertEquals("Item 1", itemList.get(0).getTitle());
    }

    @Test
    public void newListIsEmpty(){
        TaskList itemList = new TaskList();

        assertTrue(itemList.isEmpty());
    }

    @Test
    public void removingItemDecreasesSize(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertEquals(itemList.size(), 1);

        itemList.delete(0);

        assertEquals(itemList.size(), 0);
    }

    @Test
    public void removingItemFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, () -> itemList.delete(2));
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        itemList.completeItem(0);
        assertTrue(itemList.getItemStatus(0));

        itemList.unCompleteItem(0);
        assertFalse(itemList.getItemStatus(0));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);

        assertThrows(IndexOutOfBoundsException.class, () -> itemList.getItemStatus(2));
    }

    @Test
    public void savedListCanBeLoaded(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        itemList.saveFile();
        itemList.delete(0);
        itemList.loadFile();

        assertEquals("None", itemList.get(0).getDescription());
    }

    @Test
    public void clearListEmptiesList(){
        TaskList itemList = new TaskList();
        TaskItem item = new TaskItem("Item 1", "None", "2022-11-11");
        itemList.add(item);
        itemList.clearList();
        assertTrue(itemList.size() == 0);
    }

}
