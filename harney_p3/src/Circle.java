import java.lang.Math.*;

public class Circle extends Shape2D {

    private static final String name = "circle";
    private double radius;

    public Circle (double inputRadius){
        radius = inputRadius;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }
}
