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
        if (bmi >= 30) {
            return "Obesity";
        } else if (bmi >= 25) {
            return "Overweight";
        } else if (bmi >18.5) {
            return "Normal Weight";
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