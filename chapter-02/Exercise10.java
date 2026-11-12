//Exercise 10. Implement a class Car that models a car traveling along the x-axis, consuming gas as it moves. Provide methods to drive by a given number of miles, to add a given number of gallons to the gas tank, and to get the current distance from the origin and fuel level. Specify the fuel efficiency (in miles/gallons) in the constructor. Should this be an immutable class? Why or why not?


//Should this be an immutable class. Why or why not?-
//Car should be a mutable class, making it immutable would not be realistic, and would require a new car created for all calculations on each use.

public class Exercise10{

public static void main(String[] args){
        var car = new Car("Accord", "Honda", 26, 17.2);
        car.PumpGas(10);
        car.Drive(100);

        System.out.println("My car is capable of driving " + car.getMaxRange() + " miles on a full tank.");
        return;
    }
}

class Car{
    private final String model;
    private final String make;
    private final double mpg;
    private final double tankSize; 
    private double gasInTank = 0.0;
    private final double maxRange;

    public Car(String model, String make, double mpg, double tankSize){
        this.model = model;
        this.make = make;
        this.mpg = mpg;
        this.tankSize = tankSize;
        this.maxRange = mpg * tankSize;
    }

    public void PumpGas(double gallonsPumped){
        double difference = 0.0;
        this.gasInTank = (gasInTank + gallonsPumped);

        if(gasInTank > tankSize){
            difference = (gasInTank - tankSize);
            gasInTank = tankSize;
        }

        System.out.println(gallonsPumped + " gallons pumped.");
        System.out.println(model + " has " + gasInTank + " gallons of gas.");
        if(difference > 0)
            System.out.println(difference + " gallons. Returned to vendor.");
    
    }

    public void Drive(double milesDriven){ 
        double totalPossibleMiles = mpg * gasInTank;
        if(milesDriven > totalPossibleMiles){
            System.out.println("You ain't got enough gas jack");
            return;
        }
        double gallonsUsed = (milesDriven / mpg);
        gasInTank = (gasInTank - gallonsUsed);
        String gasInTankF = String.format("%.2f", gasInTank);
        System.out.println(milesDriven + " miles driven. " + gasInTankF + " gallons remaining in tank.");
        return;

    }
    ///////getters
    public String getModel(){
        return model;
    }
    public String getMake(){
        return make;
    }
    public double getMpg(){
        return mpg;
    }
    public double getTankSize(){
        return tankSize;
    }
    public double getGasInTank(){
        return gasInTank;
    }
    public double getMaxRange(){
        return maxRange;
    }
}