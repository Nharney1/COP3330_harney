public class BodyMassIndex {

    private double bmi;
    private String bmiCategory;

    public BodyMassIndex(double heightInput, double weightInput) {
        double height = heightInput;
        double weight = weightInput;

        bmi = bmiCalculator(height, weight);

        bmiCategory = category(bmi);

    }

    public double bmiCalculator(double height, double weight) {
        double bmiCalculation = 703 * weight / (height * height);
        return bmiCalculation;
    }

    public String category(double inputBmi) {
        if (inputBmi >= 30) {
            return "Obesity";
        } else if (inputBmi >= 25) {
            return "Overweight";
        } else if (inputBmi > 18.5) {
            return "Normal weight";
        } else
            return"Underweight";

    }

    public double getBmi (){
        return bmi;
    }

    public String getCategory(){
        return bmiCategory;
    }

}