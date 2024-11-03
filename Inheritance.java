import java.util.List;
public class Inheritance {
    public static void main(String[] args) {
        
    }
}

abstract class Shape{
    int dimension1, dimension2;
    abstract int area();
}

class Circle extends Shape{
    Circle(int dimension1){
        super.dimension1 = dimension1;
    }
    public int area(){
        return (22 * dimension1 * dimension1)/7;
    }
}

class Square extends Shape{
    Square(int dimension1){
        super.dimension1 = dimension1;
    }
    public int area(){
        return dimension1 * dimension1;
    }
}

class Rectangle extends Shape{
    Rectangle(int dimension1, int dimension2){
        super.dimension1 = dimension1;
        super.dimension2 = dimension2;
    }
    public int area(){
        return 2 * (dimension1 * dimension2);
    }
}

class Student{
    private static int reg = 1;
    String name;
    int age;
    int regNo;
    Student(String name, int age){
        this.name = name;
        this.age = age;
        regNo = reg++;
    }
    public void displayDetails(){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Register No. : " + regNo);
    }
}

class ZSGSStudent extends Student{
    private static int id = 1;
    String location;
    int zohoId;
    ZSGSStudent(String name, int age, String location){
        super(name, age);
        this.location = location;
        zohoId = id++;
    }

    public void displayDetails(){
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Register No. : " + regNo);
        System.out.println("Location : " + location);
        System.out.println("ZOHO ID : " + zohoId);
    }
}

// Vehicle Hierarchy

class Vehicle{
    // Parent Class
}
interface PetrolorDiesel{

}
interface Electric{

}
// Child classes of Vehicle
class TwoWheelers extends Vehicle{

}
class FourWheelers extends Vehicle{

}
// Child classes of TwoWheelers
class Bike extends TwoWheelers{

}
class Scooter extends TwoWheelers{

}
class EVScooter extends TwoWheelers implements Electric{

}
// Child classes of FourWheelers
class Car extends FourWheelers{

}
// Child classes of Car
class PetrolCar extends Car implements PetrolorDiesel{

}
class Sedan extends PetrolCar{

}
class SUV extends PetrolCar{

}
class HatchBack extends PetrolCar{

}
class EVCars extends Car implements Electric{

}

// Class Diagram

class LibraryManagementSystem{
    String userType;
    String userName;
    String password;
    void login(){}
    void register(){}
    void logout(){}
}

class User extends LibraryManagementSystem{
    String name;
    int id;
    void verify(){}
    void checkAccount(){}
    void get_book_info(){}
}

class Staff extends User{
    String dept;
}

class LibStudent extends User{
    String sClass;
}

class Account extends User{
    int no_borrowed_books;
    int no_reserved_books;
    int no_returned_books;
    int no_lost_books;
    int fine_amount;
    void calculateFine(){}
}

class Book extends LibraryManagementSystem{
    String title, author, isbn, publication;
    void showDueDt(){}
    void reservationStatus(){}
    void feedback(){}
    void bookRequest(){}
    void renwInfo(){}
}

class Librarian extends LibraryManagementSystem{
    String name;
    int id;
    String password, searchString;
    void verifyLibrarian(){}
    void search(){}
}

class LibraryDatabase extends Librarian{
    List<Book> listOfBooks;
    void add(){}
    void delete(){}
    void update(){}
    void display(){}
    void search(){}
}

class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

      boolean isVulnerable() {
        return false;
    }
    
    public String toString() {
        return "Fighter is a Warrior";
    }

    int getDamagePoints(Fighter wizard) {
        return wizard.isVulnerable() ? 10: 6;
    }
}

class Wizard extends Fighter {

    private boolean hasPreparedSpell = false;
    
    
    boolean isVulnerable() {
        return !hasPreparedSpell;
    }

    
    int getDamagePoints(Fighter warrior) {
        return hasPreparedSpell ? 12 : 3;
    }

    void prepareSpell() {
        hasPreparedSpell = true; 
    }

    public String toString() {
        return "Fighter is a Wizard";
    }

}