import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);

        assertEquals(contactList.size(), 1);
    }

    @Test
    public void editingItemFailsWithAllBlankValues(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);

        assertThrows(IllegalArgumentException.class, ()-> contactList.editItem(" ", " ",
                " ", " ",0));
    }

    @Test
    public void editingItemFailsWithInvalidIndex(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);

        assertThrows(IndexOutOfBoundsException.class, () ->
                contactList.editItem("Name", " ", " ", " ",2));

    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editItem("  ", "Smith", "123-123-1234", "email@gmail.com", 0);

        assertTrue(contactList.get(0).getFirstName().isBlank());
        assertEquals("Smith", contactList.get(0).getLastName());
        assertEquals("123-123-1234", contactList.get(0).getPhoneNumber());
        assertEquals("email@gmail.com", contactList.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editItem("Alex", "  ", "123-123-1234", "email@gmail.com", 0);

        assertEquals("Alex",contactList.get(0).getFirstName());
        assertTrue(contactList.get(0).getLastName().isBlank());
        assertEquals("123-123-1234", contactList.get(0).getPhoneNumber());
        assertEquals("email@gmail.com", contactList.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhoneNumber(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editItem("Alex", "Smith", "", "email@gmail.com", 0);

        assertEquals("Alex",contactList.get(0).getFirstName());
        assertEquals("Smith", contactList.get(0).getLastName());
        assertTrue(contactList.get(0).getPhoneNumber().isBlank());
        assertEquals("email@gmail.com", contactList.get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editItem("Alex", "Smith", "123-123-1234", "", 0);

        assertEquals("Alex",contactList.get(0).getFirstName());
        assertEquals("Smith", contactList.get(0).getLastName());
        assertEquals("123-123-1234", contactList.get(0).getPhoneNumber());
        assertTrue( contactList.get(0).getEmail().isBlank());
    }

    @Test
    public void editingSucceedsWithNoBlankValues(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editItem("Alex", "Smith", "123-123-1234", "email@gmail.com", 0);

        assertEquals("Alex",contactList.get(0).getFirstName());
        assertEquals("Smith", contactList.get(0).getLastName());
        assertEquals("123-123-1234",contactList.get(0).getPhoneNumber());
        assertEquals("email@gmail.com", contactList.get(0).getEmail());
    }

    @Test
    public void newListIsEmpty(){
        ContactList contactList = new ContactList();

        assertTrue(contactList.isEmpty());
    }

    @Test
    public void removingItemDecreasesSize(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        assertEquals(contactList.size(), 1);
        contactList.delete(0);
        assertEquals(contactList.size(), 0);
    }

    @Test
    public void removingItemFailsWithInvalidIndex(){
        ContactItem contact = new ContactItem("Noah", "Harney", "  ", "email@email.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);

        assertThrows(IndexOutOfBoundsException.class, ()-> contactList.delete(1));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList contactList = new ContactList();
        ContactItem item = new ContactItem("Jim", "Brown", "  ", "email.com" );
        contactList.add(item);
        contactList.saveFile();
        contactList.delete(0);
        contactList.loadFile();

        assertEquals("Jim",contactList.get(0).getFirstName());
        assertTrue(contactList.get(0).getPhoneNumber().isBlank());
    }

    @Test
    public void clearListEmptiesList(){
        ContactList itemList = new ContactList();
        ContactItem item = new ContactItem("Brandon", "Smith", " ", " ");
        itemList.add(item);
        itemList.clearList();
        assertTrue(itemList.size() == 0);
    }
}
