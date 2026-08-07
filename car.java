import java.util.Scanner;
class Car {
    String model;
    double price;
    Car() {
        model = "Not Specified";
        price = 0;
    }
    Car(String model) {
        this.model = model;
        price = 0;
    }
    Car(String model, double price) {
        this.model = model;
        this.price = price;
    }
    void display() {
        System.out.println("Car Model : " + model);
        System.out.println("Car Price : " + price);
        System.out.println();
    }
}
public class CarDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car car1 = new Car();
        System.out.print("Enter Car Model: ");
        String model = sc.nextLine();
        Car car2 = new Car(model);
        System.out.print("Enter Car Model: ");
        String model2 = sc.nextLine();
        System.out.print("Enter Car Price: ");
        double price = sc.nextDouble();
        Car car3 = new Car(model2, price);
        System.out.println("\nCar 1 Details");
        car1.display();
        System.out.println("Car 2 Details");
        car2.display();
        System.out.println("Car 3 Details");
        car3.display();
        sc.close();
    }
}
