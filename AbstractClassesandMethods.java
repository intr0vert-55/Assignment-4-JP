import java.util.List;
import java.util.ArrayList;
public class AbstractClassesandMethods{
    public static void main(String [] args){
        // Employee
        HourlyEmployee hourly = new HourlyEmployee("Leon Scott Kennedy", "Junior Secret Agent", "IMF", 1000);
        MonthlySalariedEmployee monthly = new MonthlySalariedEmployee("Ada Wong", "Mercenary", "Self-Employed", 2500000);
        hourly.printEmployeeDetails();
        hourly.calculatePay();
        monthly.printEmployeeDetails();
        monthly.calculatePay();

        // Product
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new ElectronicProduct(299, "Smartphone"));
        cart.addProduct(new ClothingProduct(59, "T-shirt"));
        cart.addProduct(new BookProduct(19, "Novel"));

        cart.displayCart();

        // Movie

        Actor tc = new Actor("Tom Cruise", 62);
        Actor ha = new Actor("Hayley Atwell", 42);
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(tc);
        actors.add(ha);
        // Movie movie = new Movie("Mission Impossible : Dead Reckoning Part - II", "21st May 2025", 400000000, actors);
        Movie thrillerMovie = new ThrillerMovie("Mission Impossible : Dead Reckoning Part - II", "21st May 2025", 400000000, actors);
        actors.removeAll(actors);
        actors.add(new Actor("Elisha Cuthbert", 41));
        actors.add(new Actor("Emile Hirsch", 39));
        Movie romComMovie = new RomComMovie("The Girl Next Door", "4th March 2004", 210000000, actors);
        // movie.movieContext();
        thrillerMovie.movieContext();
        romComMovie.movieContext();

    }
}
// Employee
abstract class Employee{
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

    protected int checkSalary(){
        return salary;
    }

    abstract void calculatePay();

    protected void hrAccess(){
        printEmployeeDetails();
        System.out.println("Salary : " + checkSalary());
    }
}

class HourlyEmployee extends Employee{
    HourlyEmployee(String name, String role, String team, int salary){
        super(name, role, team, salary);
    }

    void calculatePay(){
        System.out.println("Salary : " + (checkSalary() * 9) * 25 * 12);
    }
}

class MonthlySalariedEmployee extends Employee{
    MonthlySalariedEmployee(String name, String role, String team, int salary){
        super(name, role, team, salary);
    }

    void calculatePay(){
        System.out.println("Salary : " + (checkSalary() * 12));
    }
}

// Product

abstract class Product{
    abstract int getPrice();
    abstract String getDescription();
}

class ElectronicProduct extends Product{
    int price;
    String description;
    ElectronicProduct(int price, String description){
        this.price = price;
        this.description = description;
    }
    int getPrice(){
        return price;
    }
    String getDescription(){
        return description;
    }
}
class ClothingProduct extends Product{
    int price;
    String description;
    ClothingProduct(int price, String description){
        this.price = price;
        this.description = description;
    }
    int getPrice(){
        return price;
    }
    String getDescription(){
        return description;
    }
}
class BookProduct extends Product{
    int price;
    String description;
    BookProduct(int price, String description){
        this.price = price;
        this.description = description;
    }
    int getPrice(){
        return price;
    }
    String getDescription(){
        return description;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayCart() {
        int totalPrice = 0;
        for (Product product : products) {
            System.out.println("Product: " + product.getDescription() + " | Price: $" + product.getPrice());
            totalPrice += product.getPrice();
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}

// Movie

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

abstract class Movie{
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
    abstract void movieContext();
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

