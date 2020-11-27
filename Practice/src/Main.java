import java.util.ArrayList;

public class Main {

    public static void main (String [] args){

    /*    Practice newFile = new Practice();
        newFile.openFile();
        newFile.addRecords();
        newFile.closeFile();

        fileReader read = new fileReader();
        read.openFile();
        read.readFile();
        read.closeFile();
    */

        String testString = "2020_11_02";
        boolean testResult = false;

        if(Character.isDigit(testString.charAt(2))){
            testResult = true;
        }

        System.out.println(testResult);

        People newInput = new People("Bill", "1234", "Engineer");
        People Matt = new People("Matt", "2345", "Teacher");
        People Matheus = new People("Matheus", "3456", "Dance teacher");

        ArrayList<People> names = new ArrayList<>();

        names.add(newInput);
        names.add(Matt);
        names.add(Matheus);

        for (People people : names ){
            System.out.println(people.toString());
        }

        names.get(1).setName("Please Work");

        for (People people : names ){
            System.out.println(people.toString());
        }
    }

}

