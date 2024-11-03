import java.util.List;
import java.util.ArrayList;
public class MethodOverriding {
    public static void main(String [] args){
        // Employee
        Employee employee = new Employee("Ethan Hunt", "Senior Secret Agent", "IMF", 1000000);
        Employee hourlyEmployee = new HourlyEmployee("Leon Scott Kennedy", "Junior Secret Agent", "IMF", 2500000, 2000);
        Employee intern = new Intern("James Bond", "Temporary Agent", "IMF", 15000000, 36);
        System.out.println("Employee : ");
        employee.printEmployeeDetails();
        System.out.println("Hourly Employee : ");
        hourlyEmployee.printEmployeeDetails();
        System.out.println("Intern : ");
        intern.printEmployeeDetails();

        // Vehicle
        System.out.println();
        System.out.println("Vehicles : ");
        Vehicle bike = new Bike();
        bike.start();
        // Vehicle car = new PetrolCar();
        // car.changeGear();    // Error because changeGear() method is not available in it's parent class scope
        PetrolCar car = new PetrolCar();    // PetrolOrDiesel car = new PetrolCar() is also valid here but we cannot use start() and stop() if we did so
        car.start();
        car.changeGear();
        Vehicle scooter = new EVScooter();
        scooter.stop();
        System.out.println();

        // Movie
        Actor tc = new Actor("Tom Cruise", 62);
        Actor ha = new Actor("Hayley Atwell", 42);
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(tc);
        actors.add(ha);
        Movie movie = new Movie("Mission Impossible : Dead Reckoning Part - II", "21st May 2025", 400000000, actors);
        Movie thrillerMovie = new ThrillerMovie("Mission Impossible : Dead Reckoning Part - II", "21st May 2025", 400000000, actors);
        actors.removeAll(actors);
        actors.add(new Actor("Elisha Cuthbert", 41));
        actors.add(new Actor("Emile Hirsch", 39));
        Movie romComMovie = new RomComMovie("The Girl Next Door", "4th March 2004", 210000000, actors);
        movie.movieContext();
        thrillerMovie.movieContext();
        romComMovie.movieContext();
    }
}

// Employee
class Employee{
    static int id = 1;
    private int eid;
    private String name;
    private String role;
    private String team;
    private int salary;

    public Employee(String name, String role, String team, int salary){
        eid = id++;
        this.name = name;
        this.role = role;
        this.team = team;
        this.salary = salary;
    }

    public void printEmployeeDetails(){
        System.out.println("Employee id : " + eid);
        System.out.println("Employee Name : " + name);
        System.out.println("Role : " + role);
        System.out.println("Team : " + team);
    }

    private int checkSalary(){
        return salary;
    }

    protected void hrAccess(){
        printEmployeeDetails();
        System.out.println("Salary : " + checkSalary());
    }
}
class HourlyEmployee extends Employee{
    private int hourlyPay;
    HourlyEmployee(String name, String role, String team, int salary, int hourlyPay){
        super(name, role, team, salary);
        this.hourlyPay = hourlyPay;
    }
    @Override
    public void printEmployeeDetails() {
        // TODO Auto-generated method stub
        super.printEmployeeDetails();
        System.out.println("Hourly Pay : " + hourlyPay);
    }
}

class Intern extends Employee{
    private int duration;
    Intern(String name, String role, String team, int salary, int duration){
        super(name, role, team, salary);
        this.duration = duration;
    }
    @Override
    public void printEmployeeDetails() {
        // TODO Auto-generated method stub
        super.printEmployeeDetails();
        System.out.println("Duration of internship : " + duration + " months");
    }

}

// Overriding in vehicle

abstract class Vehicle{
    // Parent Class
    abstract void start();
    abstract void stop();
}
interface PetrolorDiesel{
    abstract void changeGear();
}
interface Electric{
    abstract void regen();
}
// Child classes of Vehicle
abstract class TwoWheelers extends Vehicle{
    // abstract void start();
    // abstract void stop();
}
abstract class FourWheelers extends Vehicle{
    // abstract void start();
    // abstract void stop();
}
// Child classes of TwoWheelers
class Bike extends TwoWheelers implements PetrolorDiesel{
    void start(){
        System.out.println("Use the self start and start the bike");
    }
    void stop(){
        System.out.println("Apply brakes and stop the bike");
    }
    public void changeGear(){
        System.out.println("Gears can be upshifted or downshifted. Engine braking can also be used.");
    }
}
class EVScooter extends TwoWheelers implements Electric{
    void start(){
        System.out.println("Use the self start and start the scooter");
    }
    void stop(){
        System.out.println("Apply brakes and stop the scooter");
    }
    public void regen(){
        System.out.println("Use the accelerator in reverse to slow down the scooter using regen.");
    }
}
// Child classes of FourWheelers
abstract class Car extends FourWheelers{

}
// Child classes of Car
class PetrolCar extends Car implements PetrolorDiesel{
    void start(){
        System.out.println("Use the self start and start the car");
    }
    void stop(){
        System.out.println("Apply brakes and stop the car");
    }
    public void changeGear(){
        System.out.println("Gears can be upshifted or downshifted. Engine braking can also be used.");
    }
}
class EVCars extends Car implements Electric{
    void start(){
        System.out.println("Use the self start and start the car");
    }
    void stop(){
        System.out.println("Apply brakes and stop the car");
    }
    public void regen(){
        System.out.println("Regen is used to increase the range of the vehicle");
    }
}

// Overriding in movie

class Actor{
    private String name;
    private int age;

    Actor(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void actorDetails(){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}

class Movie{
    private String name;
    private String releaseDate;
    private int budget;
    private List<Actor> actors;

    Movie(String name, String releaseDate, int budget, List<Actor> actors){
        this.name = name;
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.actors = actors;
    }

    public void movieDetails(){
        System.out.println("Movie Name : " + name);
        System.out.println("Release Date : " + releaseDate);
        System.out.println("Budget : " + budget);
        System.out.println("Cast : ");
        for(Actor actor : actors){
            actor.actorDetails();
        }
    }

    public void movieContext(){
        movieDetails();
        System.out.println("Movie Scene 1");
        System.out.println("Movie Scene 2");
        System.out.println("Movie Scene 3");
        System.out.println("Movie Scene 4");
    }
}

class RomComMovie extends Movie{
    RomComMovie(String name, String releaseDate, int budget, List<Actor> actors){
        super(name, releaseDate, budget, actors);
    }

    public void movieContext(){
        movieDetails();
        System.out.println("Intro of the hero and heroine");
        System.out.println("Intro of the comedian or villain along with some fillers");
        System.out.println("Blooming of love along with some comdy/fillers");
        System.out.println("Main part of the story");
        System.out.println("Ending and moral of the story");
    }
}

class ThrillerMovie extends Movie{
    ThrillerMovie(String name, String releaseDate, int budget, List<Actor> actors){
        super(name, releaseDate, budget, actors);
    }

    public void movieContext(){
        movieDetails();
        System.out.println("Intro of the hero and his usual routine");
        System.out.println("Intro of the villain along with some context and overview of the whole story");
        System.out.println("Some action/chase scene with some fillers");
        System.out.println("Climax of the story with thrilling action or an unexpected twist");
        System.out.println("Ending");
    }
}