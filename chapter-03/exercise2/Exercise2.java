//Exercise 2
// Finding Maximums & Type Casting: Extend the previous exercise by writing a method to locate the Measurable object with the highest value, retrieve the top-earning employee's name, and explain why an explicit type cast is required.

//ANSWER:
//Interface becomes Supertpye of Implementing class. IE Measurable (Interface) is a parent class to Employee. 
//Passing Child Objects into the Parent Interface - does not require explicit casting. 
//Example - 
//Measurable.average(employeeObject) // (Casting is automatically implicit)

// Passing Objects FROM the Parent Interface to a variable ((reqires EXPLICIT Casting)). 
//Example-  
// var largestHome = (Home) Measurable.largest(homes);

//NOTES:
//I continued this example on Homes class

public class Exercise2{

    static public void main(String[] args){

        //instantiate some variables
        Home[] homes = {
            new Home("100 Hooker Ave", 1800),
            new Home("101 Hooker Ave", 2400),
            new Home("102 Hooker Ave", 2100),
            new Home("103 Hooker Ave", 3150),
            new Home("104 Hooker Ave", 1450),
            new Home("105 Hooker Ave", 2750),
            new Home("106 Hooker Ave", 1950),
            new Home("107 Hooker Ave", 4200),
            new Home("108 Hooker Ave", 1600),
            new Home("109 Hooker Ave", 2900)

        };
    
        Employee[] employees = {
            new Employee("Alvin", 75000),
            new Employee("Bruno", 105000),
            new Employee("Cedric", 79000),
            new Employee("Darius", 67000),
            new Employee("Elliot", 44000),
            new Employee("Fiona", 118000),
            new Employee("Gillian", 82500),
            new Employee("Hannah", 94000),
            new Employee("Ivan", 53000),
            new Employee("Julia", 132000),
            new Employee("Killian", 61500),
            new Employee("Liam", 88000)

        };
                            ///type casting happens here
        Home largestHome = (Home) Measurable.largest(homes);
                            //type casting happens here
        Employee topEarner = (Employee) Measurable.largest(employees);
        
        System.out.println("Largest home on Hooker Ave is " + largestHome.getAddress() + " with " + largestHome.getSquareFootage() + " square feet");

        System.out.println("The employee with the largest salary is " + topEarner.getName() + " with a salary of $" + topEarner.getSalary() );

        return;
    }
}

interface Measurable {
    double getMeasure();

    public static double average(Measurable[] objects){
        if(objects.length == 0)
            return 0;
        double sum=0;
        int count=0;

        for(int i = 0; i< objects.length; i++ ){
            count++;
            sum += objects[i].getMeasure();
        }
        return sum/count;
    }

    public static Measurable largest(Measurable[] objects){
        if(objects.length == 0){
            return null;
        }

        Measurable largestObject = objects[0];
        for( Measurable object : objects ){
            if(object.getMeasure() > largestObject.getMeasure()){
                largestObject = object;
            }
        }
        return largestObject; // return the object, not the measure of the object
    }
}

class Employee implements Person, Identified, Measurable {
    //fields
    private String name;
    private double salary;
    //constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    //methods
    ///mutator
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    //getters
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }

    public int getId() { return Identified.super.getId(); }

    @Override
    public double getMeasure(){
        return salary;
        }
}


class Home implements Measurable {
    private String address;
    private double squareFootage;

    public Home(String address, double squareFootage) {
        this.address = address;
        this.squareFootage = squareFootage;
    }

    public String getAddress() {
        return address;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    @Override
    public double getMeasure() {
        return squareFootage;
    }
}