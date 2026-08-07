import java.util.Scanner;
class Area {
    void area(int side) {
        int squareArea = side * side;
        System.out.println("Area of Square = " + squareArea);
    }
    void area(int length, int breadth) {
        int rectangleArea = length * breadth;
        System.out.println("Area of Rectangle = " + rectangleArea);
    }
    void area(double radius) {
        double circleArea = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + circleArea);
    }
}
public class AreaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Area obj = new Area();
        System.out.print("Enter side of square: ");
        int side = sc.nextInt();
        System.out.print("Enter length of rectangle: ");
        int length = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int breadth = sc.nextInt();
        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();
        obj.area(side);
        obj.area(length, breadth);
        obj.area(radius);
        sc.close();
    }
}
