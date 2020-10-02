import java.lang.Math.*;

public class Pyramid extends Shape3D {

    private static final String name = "pyramid";
    private double length, width, height;

    public Pyramid(double inputLength, double inputWidth, double inputHeight) {
        length = inputLength;
        width = inputWidth;
        height = inputHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return length * calculateSlantHeight(width, height) + width * calculateSlantHeight(length, height) +length * width;

    }
    @Override
    public double getVolume () {
        return length * width * height / 3;
    }

    public double calculateSlantHeight ( double sideLength, double heightInput){
        double slantHeight = Math.sqrt(sideLength / 2 * sideLength / 2 + heightInput * heightInput);
        return slantHeight;
    }

}



