public class Square extends Shape2D{

    private static final String name = "square";
    private double sideLength;

    public Square (double inputDimension){
        sideLength = inputDimension;
    }

    @Override
    public double getArea(){
        return sideLength * sideLength;
    }
    @Override
    public String getName(){
        return name;
    }

}
