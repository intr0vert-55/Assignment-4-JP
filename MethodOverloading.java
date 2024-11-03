public class MethodOverloading {
    public static void main(String [] args){
        int iSum = add(5, 4);
        float fSum = add(5.1f, 4.9f);
        double dSum = add(5.1, 4.9);

        int iDiff = subtract(5, 4);
        float fDiff = subtract(5.1f, 4.9f);
        double dDiff = subtract(5.1, 4.9);

        int iProduct = multiply(5, 4);
        float fProduct = multiply(5.1f, 4.9f);
        double dProduct = multiply(5.1, 4.9);

        int iDiv = divide(5, 4);
        float fDiv = divide(5.1f, 4.9f);
        double dDiv = divide(5.1, 4.9);

        System.out.println("iSum : " + iSum);
        System.out.println("iDiff : " + iDiff);
        System.out.println("iProduct : " + iProduct);
        System.out.println("iDiv : " + iDiv);
        System.out.println("fSum : " + fSum);
        System.out.println("fDiff : " + fDiff);
        System.out.println("fProduct : " + fProduct);
        System.out.println("fDiv : " + fDiv);
        System.out.println("dSum : " + dSum);
        System.out.println("dDiff : " + dDiff);
        System.out.println("dProduct : " + dProduct);
        System.out.println("dDiv : " + dDiv);
        System.out.println();
        // Person
        System.out.println("Person");
        Person p1 = new Person("Name");
        Person p2 = new Person("Name", 18); 
        Person p3 = new Person("Name", 18, "Address");
        p1.displayDetails(); 
        p2.displayDetails(); 
        p3.displayDetails(); 
    }

    // Method overloading
    static int add(int num1, int num2){
        return num1 + num2;
    }
    static float add(float num1, float num2){
        return num1 + num2;
    }
    static double add(double num1, double num2){
        return num1 + num2;
    }

    static int subtract(int num1, int num2){
        return num1 - num2;
    }
    static float subtract(float num1, float num2){
        return num1 - num2;
    }
    static double subtract(double num1, double num2){
        return num1 - num2;
    }

    static int multiply(int num1, int num2){
        return num1 * num2;
    }
    static float multiply(float num1, float num2){
        return num1 * num2;
    }
    static double multiply(double num1, double num2){
        return num1 * num2;
    }

    static float divide(float num1, float num2){
        return num1/num2;
    }
    static int divide(int num1, int num2){
        return num1/num2;
    }
    static double divide(double num1, double num2){
        return num1/num2;
    }
}

class Person{
    String name, address;
    int age;
    Person(String name){
        this.name = name;
    }
    Person(String name, int age){
        this(name);
        this.age = age;
    }
    Person(String name, int age, String address){
        this(name, age);
        this.address = address;
    }

    void displayDetails(){
        System.out.println("Name : " + name);
        if(age != 0)    System.out.println("Age : " + age);
        if(!address.isEmpty())  System.out.println("Address : " + address);
    }
}
// Wizards and Warriors 2
class Character{
    String characterClass;
    int level;
    int hitPoints;
    public void setCharacterClass(String characterClass){
        this.characterClass = characterClass;
    }

    public String getCharacterClass(){
        return characterClass;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }

    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }
    public int getHitPoints(){
        return hitPoints;
    }
}

class Destination{
    String name;
    int inhabitants;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getInhabitants() {
        return inhabitants;
    }
    public void setInhabitants(int inhabitants) {
        this.inhabitants = inhabitants;
    }
}

enum TravelMethod{
    WALKING, HORSEBACK
}

class GameMaster {
    public String describe(Character character) {
        return String.format("You're a level %d %s with %s hit points.",
                             character.getLevel(),
                             character.getCharacterClass(),
                             character.getHitPoints());
    }
    
    public String describe(Destination destination) {
        return String.format("You've arrived at %s, which has %d inhabitants.",
                            destination.getName(),
                            destination.getInhabitants());
    }
    
    public String describe(TravelMethod travelMethod) {
        return String.format("You're traveling to your destination %s.",
                             switch (travelMethod) {
                                 case WALKING -> "by walking";
                                 case HORSEBACK -> "on horseback";
                             });
    }
    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return String.join(" ", describe(character), describe(travelMethod), describe(destination));
    }
    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
}
