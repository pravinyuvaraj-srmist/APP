import java.util.Scanner;
public class SupermarketBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] price = new int[5];
        int total = 0;
        System.out.println("Enter the prices of 5 products:");
        for (int i = 0; i < 5; i++) {
            price[i] = sc.nextInt();
            total += price[i];
        }
        System.out.println("Total Bill : " + total);
        if (total > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }
        sc.close();
    }
}
