import java.util.Scanner;

public class NumberPrograms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display menu for the user
        System.out.println("Choose a program to execute:");
        System.out.println("1. Check Palindrome");
        System.out.println("2. Check Armstrong Number");
        System.out.println("3. Check Xylem Number");
        System.out.println("4. Largest of Three Numbers");
        System.out.println("5. Smallest of Three Numbers");
        System.out.println("6. Addition, Subtraction, Multiplication, Division");
        System.out.println("7. Factorial of a Number");
        System.out.println("8. Check Prime Number");
        System.out.println("9. Fibonacci Series");
        System.out.println("10. Print Multiplication Table");
        
        int choice = scanner.nextInt(); // User's choice
        switch (choice) {
            case 1:
                checkPalindrome(scanner);
                break;
            case 2:
                checkArmstrong(scanner);
                break;
            case 3:
                checkXylem(scanner);
                break;
            case 4:
                largestOfThree(scanner);
                break;
            case 5:
                smallestOfThree(scanner);
                break;
            case 6:
                arithmeticOperations(scanner);
                break;
            case 7:
                factorial(scanner);
                break;
            case 8:
                checkPrime(scanner);
                break;
            case 9:
                fibonacciSeries(scanner);
                break;
            case 10:
                multiplicationTable(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please select a number between 1 and 10.");
        }
        scanner.close();
    }

    // Method to check if a number is a palindrome
    public static void checkPalindrome(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // User input number
        int originalNum = num; // Store original number for comparison
        int reversedNum = 0; // Variable to store reversed number
        
        while (num > 0) {
            reversedNum = reversedNum * 10 + num % 10; // Reverse the digits
            num /= 10; // Remove last digit from num
        }

        if (originalNum == reversedNum) {
            System.out.println(originalNum + " is a palindrome.");
        } else {
            System.out.println(originalNum + " is not a palindrome.");
        }
    }

    // Method to check if a number is an Armstrong number
    public static void checkArmstrong(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // User input number
        int sum = 0, originalNum = num; // Store original number for comparison
        int digits = String.valueOf(num).length(); // Count number of digits

        while (num > 0) {
            int digit = num % 10; // Extract last digit
            sum += Math.pow(digit, digits); // Raise to the power of digits and add to sum
            num /= 10; // Remove last digit from num
        }

        if (originalNum == sum) {
            System.out.println(originalNum + " is an Armstrong number.");
        } else {
            System.out.println(originalNum + " is not an Armstrong number.");
        }
    }

    // Method to check if a number is a Xylem number
    public static void checkXylem(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // User input number
        int oddSum = 0, evenSum = 0; // Initialize sums for odd and even digits

        while (num > 0) {
            int digit = num % 10; // Extract last digit
            if (digit % 2 == 0) {
                evenSum += digit; // Add to evenSum if even
            } else {
                oddSum += digit; // Add to oddSum if odd
            }
            num /= 10; // Remove last digit from num
        }

        if (oddSum == evenSum) {
            System.out.println("The number is a Xylem number.");
        } else {
            System.out.println("The number is not a Xylem number.");
        }
    }

    // Method to find the largest of three numbers
    public static void largestOfThree(Scanner scanner) {
        System.out.print("Enter three numbers: ");
        int a = scanner.nextInt(); // User input number a
        int b = scanner.nextInt(); // User input number b
        int c = scanner.nextInt(); // User input number c

        int largest = a; // Assume a is the largest
        if (b > largest) largest = b; // Update largest if b is greater
        if (c > largest) largest = c; // Update largest if c is greater

        System.out.println("The largest number is: " + largest);
    }

    // Method to find the smallest of three numbers
    public static void smallestOfThree(Scanner scanner) {
        System.out.print("Enter three numbers: ");
        int a = scanner.nextInt(); // User input number a
        int b = scanner.nextInt(); // User input number b
        int c = scanner.nextInt(); // User input number c

        int smallest = a; // Assume a is the smallest
        if (b < smallest) smallest = b; // Update smallest if b is lesser
        if (c < smallest) smallest = c; // Update smallest if c is lesser

        System.out.println("The smallest number is: " + smallest);
    }

    // Method for basic arithmetic operations
    public static void arithmeticOperations(Scanner scanner) {
        System.out.print("Enter two numbers: ");
        double a = scanner.nextDouble(); // User input number a
        double b = scanner.nextDouble(); // User input number b

        System.out.println("Addition: " + (a + b)); // Addition
        System.out.println("Subtraction: " + (a - b)); // Subtraction
        System.out.println("Multiplication: " + (a * b)); // Multiplication
        if (b != 0) {
            System.out.println("Division: " + (a / b)); // Division
        } else {
            System.out.println("Division: Cannot divide by zero.");
        }
    }

    // Method to calculate the factorial of a number
    public static void factorial(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // User input number
        int fact = 1; // Initialize factorial

        for (int i = 1; i <= num; i++) {
            fact *= i; // Multiply fact by i
        }
        System.out.println("Factorial of " + num + " is: " + fact);
    }

    // Method to check if a number is prime
    public static void checkPrime(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // User input number
        boolean isPrime = num > 1; // Assume num is prime if greater than 1

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // Check for factors
                isPrime = false; // Not prime if divisible
                break; // Exit loop if not prime
            }
        }
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    // Method to print Fibonacci series
    public static void fibonacciSeries(Scanner scanner) {
        System.out.print("Enter the number of terms: ");
        int terms = scanner.nextInt(); // User input number of terms
        int a = 0, b = 1; // Initialize first two terms

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " "); // Print current term
            int next = a + b; // Calculate next term
            a = b; // Update a to b
            b = next; // Update b to next
        }
        System.out.println(); // New line after printing series
    }

    // Method to print multiplication table
    public static void multiplicationTable(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // User input number

        System.out.println("Multiplication Table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }
}
