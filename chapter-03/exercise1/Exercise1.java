//Exercise 1
//Provide an interface Measurable with a method double getMeasure() that measures an object in some way. Make Employee implement Measurable. Provide a method double average(Measurable[] objects) that computes the average measure. Use it to compute the average salary of an array of employees.

//NOTES:
//I added an additional class, and did some instantation to make the Interface use case a bit more clear 

public class Exercise1{

    static public void main(String[] args){

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

    //Static interface being demo'd
    double avgHouseSquareFootage = Measurable.average(homes);
    double avgSalary = Measurable.average(employees);

    System.out.println("Average square footage is : " + avgHouseSquareFootage);
    System.out.println("Average Employee Salary is : " + avgSalary);

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