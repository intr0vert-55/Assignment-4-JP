import java.util.List;
import java.util.ArrayList;
public class ClassesAndObjects{
    public static void main(String [] args){

        // Book
        System.out.println("Book");
        Author gm = new Author("George Martin", 76);
        Book soif = new Book("Song of Ice and Fire", "0-4074-5336-9", gm);
        gm.addBooks(soif);
        soif.bookDetails();
        System.out.println();

        // Employee
        System.out.println("Employee");
        Employee eh = new Employee("Ethan Hunt", "Secret Agent", "IMF", 1000000);
        Organization imf = new Organization("IMF", "Secret Service Agency");
        imf.addEmployees(eh);
        eh.printEmployeeDetails();
        imf.printDetails();
        System.out.println();

        // Flight
        System.out.println("Flight");
        Flight airAsia = new Flight("Chennai(MAA)", "Manila(MNL)");
        airAsia.printDetails();
        System.out.println();

        // Movie
        System.out.println("Movie");
        Actor tc = new Actor("Tom Cruise", 62);
        Actor ha = new Actor("Hayley Atwell", 42);
        List<Actor> actors = new ArrayList<Actor>();
        actors.add(tc);
        actors.add(ha);
        Movie mi = new Movie("Mission Impossible : Dead Reckoning Part - II", "21st May 2025", 40000000, actors);
        mi.movieDetails();
    }
}

class Book{
    private String title;
    private String isbn;
    private Author author;

    public Book(String title, String isbn, Author author){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public void bookDetails(){
        System.out.println("Title : " + title);
        System.out.println("ISBN : " + isbn);
        System.out.println("Author Details : ");
        author.authorDetails();
    }

}
// Each book has an author which depicts a hasOne relationship
class Author{
    private String name;
    private int age;
    private List<Book> books;

    public Author(String name, int age){
        this.name = name;
        this.age = age;
        books = new ArrayList<Book>();
    }

    public void authorDetails(){
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
    }

    public void addBooks(Book book){
        books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }
}

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
// Each employee works for an organization and they can't work for two organizations while a book can have more than one authors.
// This depicts a proper hasOne relationship.
class Organization{
    private String name;
    private List<Employee> employees;
    private String type;

    public Organization(String name, String type){
        this.name = name;
        this.type = type;
        employees = new ArrayList<Employee>();
    }

    public void addEmployees(Employee employee){
        employees.add(employee);
    }

    public void printDetails(){
        System.out.println("Name : " + name);
        System.out.println("Type : "+ type);
        System.out.println("Employee count : " + employees.size());
    }
}

class Flight{
    private static int id = 1;
    private int flightId;
    private String origin;
    private String destination;

    public Flight(String origin, String destination){
        flightId = id++;
        this.origin = origin;
        this.destination = destination;
    }

    public void printDetails(){
        System.out.println("Flight ID : " + flightId);
        System.out.println("Origin : " + origin);
        System.out.println("Destination : " + destination);
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
}

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