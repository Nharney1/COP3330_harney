import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncrypterTest {

    @Test
    public void testEncrypter(){
        Encrypter a = new Encrypter();
        assertEquals("7667",a.encrypt("9009"));
    }
    @Test
    public void testEncrypter2(){
        Encrypter a = new Encrypter();
        assertEquals("3591",a.encrypt("2468"));
    }
    @Test
    public void testEncrypter3(){
        Encrypter a = new Encrypter();
        assertEquals("0462",a.encrypt("9537"));
    }
    @Test
    public void testEncrypter4(){
        Encrypter a = new Encrypter();
        assertEquals("8777",a.encrypt("0010"));
    }
    @Test
    public void testEncrypter5(){
        Encrypter a = new Encrypter();
        assertEquals("6776",a.encrypt("0990"));
    }








    @Test
    public void testDecrypter(){
        Decrypter a = new Decrypter();
        assertEquals("9009",a.decrypt("7667"));
    }
    @Test
    public void testDecrypter2(){
        Decrypter a = new Decrypter();
        assertEquals("2468",a.decrypt("3591"));
    }
    @Test
    public void testDecrypter3(){
        Decrypter a = new Decrypter();
        assertEquals("9537",a.decrypt("0462"));
    }
    @Test
    public void testDecrypter4(){
        Decrypter a = new Decrypter();
        assertEquals("0010",a.decrypt("8777"));
    }    @Test
    public void testDecrypter5(){
        Decrypter a = new Decrypter();
        assertEquals("0990",a.decrypt("6776"));
    }


}