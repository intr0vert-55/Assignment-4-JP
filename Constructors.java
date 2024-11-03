import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Constructors {
    public static void main(String [] args){

        // Book
        System.out.println("Book");
        Book [] books = new Book[3];
        addBooks(books);
        displayBooks(books);
        System.out.println();

        // Employee
        System.out.println("Employee");
        Employee [] employees = new Employee[3];
        addEmployees(employees);
        displayEmployees(employees);
        System.out.println();

        // Movie
        System.out.println("Movie");
        Movie [] movies = new Movie[3];
        addMovies(movies);
        displayMovies(movies);
    }

    public static void addBooks(Book [] bookArr){
        for(int i = 0; i < bookArr.length; i++){
            bookArr[i] = new Book("Book " + (i + 1), "0-4074-5336-" + i, new Author("Author " + (i + 1), 30 + i));
        }
    }

    public static void displayBooks(Book [] bookArr){
        for(Book book : bookArr){
            book.bookDetails();
        }
    }

    public static void addEmployees(Employee [] empArr){
        for(int i = 0; i < empArr.length; i++){
            empArr[i] = new Employee("Employee " + (i + 1), "Role " + i, "Team " + i, (i + 1) * 10000);
        }
    }

    public static void displayEmployees(Employee [] empArr){
        for(Employee employee : empArr){
            employee.printEmployeeDetails();
        }
    }

    public static void addMovies(Movie [] movieArr){
        for(int i = 0; i < movieArr.length; i++){
            movieArr[i] = new Movie("Movie " + (i + 1), "TBD", (i + 1)* 100000, new ArrayList<Actor>(Arrays.asList(new Actor("Actor " + i, 25 + i))));
        }
    }

    public static void displayMovies(Movie [] movieArr){
        for(Movie movie : movieArr){
            movie.movieDetails();
        }
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
