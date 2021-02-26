package JavaActivity1;

public class Activity1_1 {

    public static void main(String[] args) {
        Car BMW = new Car();
        BMW.make = 2014;
        BMW.color = "Black";
        BMW.transmission = "Manual";
    
        //Using Car class method
        BMW.displayCharacterstics();
        BMW.accelerate();
        BMW.brake();
    }

}