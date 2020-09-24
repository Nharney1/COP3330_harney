import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex> ();

        while (moreInput()){
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput(){
        String userInput = getUserInput();

        return userInput.equalsIgnoreCase("y");
    }

    private static String getUserInput(){
        System.out.println("Would you like to enter more data? Y or N: ");
        Scanner input = new Scanner(System.in);
        String userAnswer = input.next();
        return userAnswer;

    }

    private static double getUserHeight(){
        System.out.println("Please enter the height of the person in inches: ");
        Scanner input = new Scanner(System.in);
        double userHeightInput= input.nextDouble();
        input.nextLine();


        double verifiedHeight = verifyHeightInput(userHeightInput);
        return verifiedHeight;
    }

    private static double verifyHeightInput(double userHeightInput){
        if(userHeightInput >= 0){
            return userHeightInput;
        }
        else{
            System.out.println("Pleas enter a positive value for the height \n");
            double newHeightInput = getUserHeight();
            return newHeightInput;
        }

    }

    private static double getUserWeight() {
        System.out.println("Please enter the weight of the person in pounds: ");
        Scanner input = new Scanner(System.in);
        double userWeightInput = input.nextDouble();
        input.nextLine();

        double verifiedWeight = verifyWeightInput(userWeightInput);
        return verifiedWeight;
    }

    private static double verifyWeightInput(double userWeightInput){
        if(userWeightInput >= 0){
            return userWeightInput;
        }
        else{
            System.out.println("Pleas enter a positive value for the height \n ");
            double newWeightInput = getUserWeight();
            return newWeightInput;

        }
    }

    public static void displayBmiInfo(BodyMassIndex bmi){

        System.out.printf( "%s %.1f %s", "This person has a BMI of: ", bmi.getBmi() , " \n");
        System.out.println("This person would be classified as: " + bmi.getCategory() + "\n");

    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double bmiTotal =0;
        int counter=0;
        for(BodyMassIndex eachBmiElement: bmiData){
            bmiTotal += eachBmiElement.getBmi();
            counter++;
        }

        if (counter != 0){
            System.out.printf("%s %.1f", "The average BMI for the inputted data is" , bmiTotal/counter);
        }
        else {
            System.out.println("No BMI data was entered. The average BMI cannot be computed.");
        }
    }
}


