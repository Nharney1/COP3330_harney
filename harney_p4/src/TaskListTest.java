import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem item = new TaskItem();
        int size = TaskList.getListSize();
        item.setTitle("Valid Title");
        item.setDescription("new todo");
        item.setDueDate("2020-12-30");
        TaskList.addItem(item);
        assertTrue(size + 1 == TaskList.getListSize());
        TaskList.removeItem(0);
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem item = new TaskItem();
        item.setTitle("Valid Title");
        item.setDescription("new todo");
        item.setDueDate("2020-12-08");
        TaskList.addItem(item);

        TaskItem item2 = new TaskItem();
        item2.setTitle("a");
        item2.setDescription("");
        item2.setDueDate("2020-12-09");
        TaskList.addItem(item2);


        TaskList.editItem("New Title", "description", "2020-01-01", 0);
        assertEquals("2020-01-01 description New Title", item.toString());
        TaskList.removeItem(0);
        TaskList.removeItem(0);
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem item = new TaskItem();
        item.setTitle("Valid Title");
        item.setDescription("new todo");
        item.setDueDate("2020-12-08");
        TaskList.addItem(item);
        System.out.println(TaskList.getListSize());

        item.setDescription("New description");
        assertEquals("2020-12-08 New description Valid Title", item.toString());
        TaskList.removeItem(0);
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem item = new TaskItem();
        item.setTitle("Valid Title");
        item.setDescription("new todo");
        item.setDueDate("2020-12-08");
        TaskList.addItem(item);

        TaskItem item2 = new TaskItem();
        item2.setTitle("a");
        item2.setDescription("");
        item2.setDueDate("2020-12-09");
        TaskList.addItem(item2);

        TaskList.editItem("New Valid Title", "description", "2020-12-12", 1);
        assertEquals("2020-12-12 description New Valid Title", item2.toString());
        TaskList.removeItem(0);
        TaskList.removeItem(0);
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem item = new TaskItem();
        item.setTitle("Cool Title");
        item.setDescription("new todo");
        item.setDueDate("2020-12-08");
        TaskList.addItem(item);

        TaskList.editItem("Not Cool Title", "description", "2020-11-21", 0);
        assertEquals("2020-11-21 description Not Cool Title", item.toString());
        TaskList.removeItem(0);
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){

        int indexToTest = 5;

        try{
            TaskItem item = new TaskItem();
            item.setTitle("Valid Title");
            item.setDescription("new todo");
            item.setDueDate("2020-12-08");
            TaskList.addItem(item);

            TaskItem item2 = new TaskItem();
            item2.setTitle("a");
            item2.setDescription("");
            item2.setDueDate("2020-12-09");
            TaskList.addItem(item2);

            TaskList.editItem("Not", "description", "2022-11-21", indexToTest );
        }
        catch (IndexOutOfBoundsException ex) {
            assertEquals("Index " + indexToTest + " out of bounds for length " + TaskList.getListSize() , ex.getMessage());
        }

        TaskList.removeItem(0);
        TaskList.removeItem(0);

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        int indexToTest = 1;

        try {
            TaskItem item = new TaskItem();
            item.setTitle("Valid Title");
            item.setDescription("new todo");
            item.setDueDate("2020-12-08");
            TaskList.addItem(item);

            TaskList.editItem("New Valid Title", "", "2022-10-22",indexToTest);
        }
        catch(IndexOutOfBoundsException ex){
            assertEquals("Index " + indexToTest + " out of bounds for length " + TaskList.getListSize() , ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        int indexToTest = 2;

        try {
            TaskItem item = new TaskItem();
            item.setTitle("Title");
            item.setDescription("");
            item.setDueDate("2020-12-09");
            TaskList.addItem(item);

            TaskList.editItem("New Valid Title", "", "2022-10-22", indexToTest);
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index " + indexToTest + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void tryingToEditATaskItemUsingInvalidItemParameters(){
        int indexToTest = 0;

        try {
            TaskItem item = new TaskItem();
            item.setTitle("Title");
            item.setDescription("");
            item.setDueDate("2020-12-08");
            TaskList.addItem(item);

            TaskList.editItem("New Valid Title", "", "2022-1-09", indexToTest);
        } catch (IllegalArgumentException ex) {
            assertEquals("Please enter a valid due date", ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        int indexToTest = 2;

        try {
            TaskItem item = new TaskItem();
            item.setTitle("ToDo Item");
            item.setDescription("This is a list");
            item.setDueDate("2020-01-08");
            TaskList.addItem(item);
            TaskList.getDescription(indexToTest);

        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index " + indexToTest + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2020-11-11");
        TaskList.addItem(item);

        TaskItem item2 = new TaskItem();
        item2.setTitle("Title 2");
        item2.setDescription("Des 2");
        item2.setDueDate("2020-11-22");
        TaskList.addItem(item2);

        assertEquals("Des 2", TaskList.getDescription(1));

        TaskList.removeItem(0);
        TaskList.removeItem(0);
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        int indexToTest = 4;

        try {
            TaskItem item = new TaskItem();
            item.setTitle("ToDo Item");
            item.setDescription("This is a list");
            item.setDueDate("2020-01-08");
            TaskList.addItem(item);
            TaskList.getDueDate(indexToTest);

        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index " + indexToTest + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2020-11-11");
        TaskList.addItem(item);

        TaskItem item2 = new TaskItem();
        item2.setTitle("Title 2");
        item2.setDescription("Des 2");
        item2.setDueDate("2020-11-22");
        TaskList.addItem(item2);

        assertEquals("2020-11-11", TaskList.getDueDate(0));

        TaskList.removeItem(0);
        TaskList.removeItem(0);
    }

    @Test
    public void gettingTaskItemFailsWithInvalidIndex(){
        int indexToTest = 1;

        try {
            TaskItem item = new TaskItem();
            item.setTitle("New ToDo Item");
            item.setDescription("This is a short list");
            item.setDueDate("2045-01-08");
            TaskList.addItem(item);
            TaskList.getTitle(indexToTest);

        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Index " + indexToTest + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2022-12-21");
        TaskList.addItem(item);

        assertEquals("Title 1", TaskList.getTitle(0));
        TaskList.removeItem(0);
    }

    @Test
    public void isTaskListEmpty(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2022-12-21");
        TaskList.addItem(item);

        assertFalse(TaskList.newTaskListIsEmpty());

        TaskList.removeItem(0);
    }

    @Test
    public void isTaskListEmptyAfterDeletions(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2022-12-21");
        TaskList.addItem(item);
        TaskList.removeItem(0);

        TaskList.removeItem(0);
    }

    @Test
    public void removingTaskItemDecreasesSize(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2020-11-11");
        TaskList.addItem(item);

        TaskItem item2 = new TaskItem();
        item2.setTitle("Title 2");
        item2.setDescription("Des 2");
        item2.setDueDate("2020-11-22");
        TaskList.addItem(item2);

        int currentSize = TaskList.getListSize();

        TaskList.removeItem(0);
        TaskList.removeItem(0);

        assertEquals(currentSize - 2, TaskList.getListSize());

    }

    @Test
    public void removingTaskItemFailsWithInvalidIndex(){
      int indexToRemove = 2;

        try{
            TaskList.removeItem(indexToRemove);

        } catch(IndexOutOfBoundsException ex){
            assertEquals("Index " + indexToRemove + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2022-12-21");
        TaskList.addItem(item);
        TaskList.completeATask(0);

        assertTrue(TaskList.getCompletionStatus(0));

        TaskList.removeItem(0);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){

        int indexToTry = 1;

       try {

           TaskItem item = new TaskItem();
           item.setTitle("Title 1");
           item.setDescription("Des 1");
           item.setDueDate("2022-12-21");
           TaskList.addItem(item);
           TaskList.completeATask(indexToTry);
       } catch (IndexOutOfBoundsException ex){
           assertEquals("Index " + indexToTry + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
       }
        TaskList.removeItem(0);
    }

    @Test
    public void unCompletingTaskItemChangesStatus(){
        TaskItem item = new TaskItem();
        item.setTitle("Title 1");
        item.setDescription("Des 1");
        item.setDueDate("2022-12-21");
        TaskList.addItem(item);
        TaskList.completeATask(0);

        assertTrue(TaskList.getCompletionStatus(0));

        TaskList.unCompleteATask(0);
        assertFalse(TaskList.getCompletionStatus(0));

        TaskList.removeItem(0);
    }

    @Test
    public void unCompletingTaskItemFailsWithInvalidIndex(){
        int indexToTry = 5;

        try{
            TaskItem item = new TaskItem();
            item.setTitle("Title 1");
            item.setDescription("Des 1");
            item.setDueDate("2022-12-21");
            TaskList.addItem(item);
            TaskList.unCompleteATask(indexToTry);
        } catch(IndexOutOfBoundsException ex){
            assertEquals("Index " + indexToTry + " out of bounds for length " + TaskList.getListSize(), ex.getMessage());
        }
        TaskList.removeItem(0);
    }

    @Test
    public void savedTaskListCanBeLoaded(){

        Scanner reader;

        try{
            reader = new Scanner (new File("ToDoList.txt"));
            reader.useDelimiter(",|\\n");


            while(reader.hasNextLine()) {

                String tempDueDate = reader.next();
                String tempDescription = reader.next();
                String tempTitle = reader.next();

            }
        }
        catch(NoSuchElementException | FileNotFoundException ex){
            System.out.println("Your list has been loaded successfully\n");
        }
    }


}
