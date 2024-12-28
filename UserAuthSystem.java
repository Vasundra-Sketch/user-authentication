//  UserAuthSystem class
import java.util.Scanner;

public class UserAuthSystem {
    // Global static variables for user data
    static String db_uid;
    static String db_pwd;
    static String db_contact;
    static int db_age;
    static boolean did_signup_done = false;

    public void signup(String userId, String contact, String password, int age) {
        db_uid = userId;
        db_contact = contact;
        db_pwd = password;
        db_age = age;
        did_signup_done = true;
        System.out.println("Signup successful! Please login.");
    }

    public boolean login(String userId, String password) {
        if (did_signup_done && userId.equals(db_uid) && password.equals(db_pwd)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid user ID or password.");
            return false;
        }
    }

    public void recoverPassword(String contact) {
        if (contact.equals(db_contact)) {
            System.out.println("An OTP has been sent to your contact.");
            int sys_otp = (int)(Math.random() * 9999 + 9999);
            System.out.println(sys_otp);
            System.out.print("Enter OTP to reset password: ");
            Scanner sc = new Scanner(System.in);
            int otp = sc.nextInt();
            
            if (otp == sys_otp) {
                sc.nextLine();
                System.out.println("Enter new password: ");
                String newPassword = sc.nextLine();
                db_pwd = newPassword;
                System.out.println("Password reset successful!");
            } else {
                System.out.println("Invalid OTP.");
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to Logic Master");
            System.out.println("1. Number System");
            System.out.println("2. Zomatoservice");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Number System.");
                    NumberPrograms.main(new String[0]);  // Call NumberPrograms
                    break;
                case 2:
                    System.out.println("You selected Zomatoservice.");
                    Zomatoservice.main(new String[0]);  // Call ZomatoService
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserAuthSystem authSystem = new UserAuthSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Logic Master");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Forgot Password");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    authSystem.signup(userId, contact, password, age);
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    String loginId = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    if (authSystem.login(loginId, loginPassword)) {
                        authSystem.displayMenu();
                    }
                    break;

                case 3:
                    System.out.print("Enter your contact: ");
                    String recoveryContact = scanner.nextLine();
                    authSystem.recoverPassword(recoveryContact);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
