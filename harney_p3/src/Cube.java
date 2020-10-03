public class Cube extends Shape3D {

    private static final String name = "cube";
    private double sideLength;

    public Cube (double inputDimension){
        sideLength = inputDimension;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getArea(){
        return 6 * sideLength * sideLength;
    }

    @Override
    public double getVolume(){
        return sideLength * sideLength * sideLength;
    }

}
