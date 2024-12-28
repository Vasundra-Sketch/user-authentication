import java.util.Scanner;

class Zomatoservice {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\t\tWelcome to Zomato.com");
        System.out.println("\t\t\t----------------------");
        System.out.println("\t\t\tSelect the Restaurant");
        System.out.println("1. Bhauri\n2. A2B\n3. Amma Canteen\n4. Bilal");

        int Restaurant = sc.nextInt();
        double price = 0;

        switch (Restaurant) {
            case 1:
                System.out.println("Welcome to Bhauri! Select the item");
                System.out.println("1. Mutton Briyani\n2. Chicken Briyani\n3. Chicken 65");
                int Food = sc.nextInt();

                switch (Food) {
                    case 1:
                        price = 360;
                        System.out.println("Mutton Briyani: Rs. " + price);
                        break;
                    case 2:
                        price = 320;
                        System.out.println("Chicken Briyani: Rs. " + price);
                        break;
                    case 3:
                        price = 200;
                        System.out.println("Chicken 65: Rs. " + price);
                        break;
                    default:
                        System.out.println("Invalid item");
                        return;
                }
                break;

            case 2:
                System.out.println("Welcome to A2B! Select the item");
                System.out.println("1. Idly\n2. Pongal\n3. Poori");
                Food = sc.nextInt();  // Reusing the 'Food' variable here

                switch (Food) {
                    case 1:
                        price = 20;
                        System.out.println("Idly: Rs. " + price);
                        break;
                    case 2:
                        price = 32;
                        System.out.println("Pongal: Rs. " + price);
                        break;
                    case 3:
                        price = 20;
                        System.out.println("Poori: Rs. " + price);
                        break;
                    default:
                        System.out.println("Invalid item");
                        return;
                }
                break;

            case 3:
                System.out.println("Welcome to Amma Canteen! Select the item");
                System.out.println("1. Idly\n2. Sambar Rice\n3. Curd Rice");
                Food = sc.nextInt();

                switch (Food) {
                    case 1:
                        price = 5;
                        System.out.println("Idly: Rs. " + price);
                        break;
                    case 2:
                        price = 10;
                        System.out.println("Sambar Rice: Rs. " + price);
                        break;
                    case 3:
                        price = 10;
                        System.out.println("Curd Rice: Rs. " + price);
                        break;
                    default:
                        System.out.println("Invalid item");
                        return;
                }
                break;

            case 4:
                System.out.println("Welcome to Bilal! Select the item");
                System.out.println("1. Grilled Chicken\n2. Shawarma\n3. Falafel");
                Food = sc.nextInt();

                switch (Food) {
                    case 1:
                        price = 240;
                        System.out.println("Grilled Chicken: Rs. " + price);
                        break;
                    case 2:
                        price = 120;
                        System.out.println("Shawarma: Rs. " + price);
                        break;
                    case 3:
                        price = 80;
                        System.out.println("Falafel: Rs. " + price);
                        break;
                    default:
                        System.out.println("Invalid item");
                        return;
                }
                break;

            default:
                System.out.println("Choose proper restaurant");
                return;
        }

        // After selecting food
        System.out.println("\t\t\tSelect the Quantity:");
        double qty = sc.nextDouble();
        double Sys_bill = qty * price;
        System.out.println("Total Bill: " + Sys_bill);

        System.out.println("\t\t\tSelect the payment method:");
        System.out.println("1. Gpay\n2. PhonePe");
        int payment_method = sc.nextInt();

        System.out.println("Enter the bill amount:");
        double bill_amount = sc.nextDouble();

        if (bill_amount == Sys_bill) {
            System.out.println("Get OTP");
        } else {
            System.out.println("Order failed");
            return;
        }

        System.out.println("OTP no.:");
        int sys_otp = (int) (Math.random() * 9000) + 1000;  // Generates a 4-digit OTP
        System.out.println(sys_otp);

        System.out.println("Enter OTP:");
        int otp = sc.nextInt();

        if (sys_otp == otp) {
            System.out.println("Order placed");
        } else {
            System.out.println("Order failed enter valid otp!");
        }
    }
}

