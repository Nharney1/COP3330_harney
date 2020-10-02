public class Triangle extends Shape2D {

    private static final String name = "triangle";
    private double height, length;

    public Triangle (double inputHeight, double inputLength){
        height = inputHeight;
        length = inputLength;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return .5 * height * length;
    }
}
