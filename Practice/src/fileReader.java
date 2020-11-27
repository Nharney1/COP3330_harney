/* import java.io.*;
import java.util.*;


public class fileReader {

    private Scanner reader;

    public void openFile(){
        try {
            reader = new Scanner(new File("writing.txt"));
        }
        catch(Exception e){
            System.out.println("Cannot find the file");
        }
    }

    public void readFile(){
        while(reader.hasNext()){
            String number = reader.next();
            String name = reader.next();

            // Put in Arraylist
        }
    }

    public void closeFile(){
        reader.close();
    }

}
*/