package Week6Homework;

public class Distance {
    private final double value;
    private final String unitate;

    public Distance(double value, String unitate){
        this.value = value;
        this.unitate = unitate;
    }

    public static double convertToCm(double value, String unitate){
        switch (unitate){
            case "mm":
                return value /10;
            case "dm":
                return value *10;
            case "m":
                return value *100;
            case "km":
                return value *100000;
            default:
                return value;
        }
    }

    public double getValue(){
        return value;
    }

    public String getUnitate() {
        return unitate;
    }
}