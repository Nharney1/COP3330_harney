import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, ()-> {
            ContactItem a = new ContactItem("     ", "  ", "", "");
        });
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-456-7890", "   ");

        assertEquals("Noah", a.getFirstName());
        assertEquals("Harney",a.getLastName());
        assertEquals("123-456-7890", a.getPhoneNumber());
        assertTrue(a.getEmail().isBlank());
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem a = new ContactItem("", "Harney", "123-456-7890", "email@email.com");

        assertTrue( a.getFirstName().isBlank());
        assertEquals("Harney",a.getLastName());
        assertEquals("123-456-7890", a.getPhoneNumber());
        assertEquals("email@email.com", a.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem a = new ContactItem("Noah", "", "123-456-7890", "email@email.com");

        assertEquals("Noah", a.getFirstName());
        assertTrue(a.getLastName().isBlank());
        assertEquals("123-456-7890", a.getPhoneNumber());
        assertEquals("email@email.com", a.getEmail());
    }

    @Test
    public void creationSucceedsWithBlankPhoneNumber(){
        ContactItem a = new ContactItem("Noah", "Harney", "         ", "email@email.com");

        assertEquals("Noah", a.getFirstName());
        assertEquals("Harney",a.getLastName());
        assertTrue(a.getPhoneNumber().isBlank());
        assertEquals("email@email.com", a.getEmail());
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");

        assertEquals("Noah", a.getFirstName());
        assertEquals("Harney",a.getLastName());
        assertEquals("123-123-1234", a.getPhoneNumber());
        assertEquals("email@email.com", a.getEmail());
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");

        assertThrows(IllegalArgumentException.class, () -> a.updateContactItem("   ", "", " ", "    "));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");
        a.updateContactItem("Jim", "Brown", "222-234-2980", " ");

        assertEquals("Jim", a.getFirstName());
        assertEquals("Brown",a.getLastName());
        assertEquals("222-234-2980", a.getPhoneNumber());
        assertTrue(a.getEmail().isBlank());
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");
        a.updateContactItem("   ", "Brown", "222-234-2980", "email.com");

        assertTrue(a.getFirstName().isBlank());
        assertEquals("Brown",a.getLastName());
        assertEquals("222-234-2980", a.getPhoneNumber());
        assertEquals("email.com", a.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");
        a.updateContactItem("Jim", "   ", "222-234-2980", "email.com");

        assertEquals("Jim", a.getFirstName());
        assertTrue(a.getLastName().isBlank());
        assertEquals("222-234-2980", a.getPhoneNumber());
        assertEquals("email.com", a.getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhoneNumber(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");
        a.updateContactItem("Jim", "Brown", "     ", "email.com");

        assertEquals("Jim", a.getFirstName());
        assertEquals("Brown",a.getLastName());
        assertTrue(a.getPhoneNumber().isBlank());
        assertEquals("email.com", a.getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem a = new ContactItem("Noah", "Harney", "123-123-1234", "email@email.com");
        a.updateContactItem("Jim", "Brown", "222-234-2980", "email.com");

        assertEquals("Jim", a.getFirstName());
        assertEquals("Brown",a.getLastName());
        assertEquals("222-234-2980", a.getPhoneNumber());
        assertEquals("email.com", a.getEmail());
    }

    @Test
    public void contactItemToStringTest(){
        ContactItem a = new ContactItem("Tim", "Smith", "407-407-4070", "email@gmail.com");

        assertEquals("Tim Smith 407-407-4070 email@gmail.com", a.toString());
    }
}
