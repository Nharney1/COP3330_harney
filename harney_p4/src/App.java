import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        mainMenu();
    }

    private static void printMainMenu(){
        System.out.println("Main Menu");
        System.out.println("_________\n");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.print("3) Quit\n\n");
    }

    private static String getMainMenuInput(){

        Scanner input = new Scanner(System.in);
        String userInput = input.next();

        return userInput;
    }

    private static void actOnMainMenuInput(String userInput){
        try{
            if(userInput.equals("1")){
                System.out.println("create a new list");
            }
            else if (userInput.equals("2")){
                System.out.println("load an existing list");
            }
            else if (userInput.equals("3")){
                System.out.println("quit");
            }
            else {
                throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException ex){
            System.out.println("Please enter a valid selection for the main menu options\n\n");
            mainMenu();
        }

    }

    private static void mainMenu(){
        String userInput = null;

        printMainMenu();
        userInput = getMainMenuInput();
        actOnMainMenuInput(userInput);

    }
}
