import java.lang.Math.*;

public class Sphere extends Shape3D {

    private static final String name = "sphere";
    private double radius;

    public Sphere( double inputRadius){
        radius = inputRadius;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getVolume(){
        return (4.0/3.0) *Math.PI * radius * radius *radius;
    }

}
