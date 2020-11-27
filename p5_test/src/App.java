import java.util.Scanner;

public class App  {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.begin();
    }

    private void begin(){
        homeScreen();
    }

    private void homeScreen(){
        printHomeScreenOptions();
        String homeScreenInput = getHomeScreenInput();
        homeScreenDecision(homeScreenInput);
    }

    private void printHomeScreenOptions(){
        System.out.println("Select Your Application");
        System.out.println("------------------------");
        System.out.println("1) Task List");
        System.out.println("2) Contact List");
        System.out.println("3) Quit");

    }

    private String getHomeScreenInput(){
        System.out.print(">");
        return input.nextLine();
    }

    private void homeScreenDecision(String input){
        try{
            switch(input){
                case "1" -> createNewTaskApp();
                case "2" -> createNewContactApp();
                case "3" -> System.exit(0);
                default -> throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println("Please enter a valid selection for the main menu options.\n");
            homeScreen();
        }
    }

    private void createNewTaskApp(){
        TaskApp app = new TaskApp();
        app.Menu();
    }

    private void createNewContactApp(){
        ContactApp app = new ContactApp();
        app.Menu();
    }



}
