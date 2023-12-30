import java.util.Arrays;
import java.util.Scanner;

public class Assignment1 {

    Scanner input;

    Assignment1() {
        input = new Scanner(System.in);
    }

    public void displayProblemList() {

        while (true) {
            System.out.println("\nChose a problem form the list below :");
            // Display menu
            System.out.println("0. Press 0 (zero) to Quit!");
            System.out.println("1. Sum of Array Elements");
            System.out.println("2. Largest Element in Array");
            System.out.println("3. Even or Odd Numbers (Count in Array)");
            System.out.println("4. Reverse an Array");
            System.out.println("5. Factorial Calculation");
            System.out.println("6. Palindrome Check");
            System.out.println("7. Prime Number Check");
            System.out.println("8. Fibonacci Series");
            System.out.println("9. Linear Search");
            System.out.println("10. Binary Search");
            System.out.println("11. Duplicate Elements");
            System.out.println("12. Count Vowels and Consonants");
            System.out.println("13. Multiplication Table");
            System.out.println("14. Matrix Addition");
            System.out.println("15. Calculate Average");
            System.out.println("16. Leap Year Check");
            System.out.println("17. Pattern Printing");
            System.out.println("18. String Reversal");
            System.out.println("19. Armstrong Number");
            System.out.println("20. Find Minimum and Maximum");
            System.out.println("21. Calculate Simple Interest");
            System.out.println("22. Temperature Conversion");
            System.out.println("23. Character Type Check");
            System.out.println("24. Second Largest Number");
            System.out.println("25. Sum of Numbers in a String");

            int choice = input.nextInt();

            if (choice == 0) {
                System.out.println("Thank you!");
                break;
            } else {
                answerOf(choice);
            }
        }
    }

    private int answerOf(int choice) {

        int[] array = {1, 3, 2, 5, 4};
        System.out.print("The array elements are: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        // Perform operation based on user's choice
        switch (choice) {
            case 1:
                int sum = calculateSum(array);
                System.out.println("Sum of Array Elements: " + sum);
                break;
            case 2:
                int largest = findLargestElement(array);
                System.out.println("Largest Element in Array: " + largest);
                break;
            case 3:
                int evenCount = countEvenNumbers(array);
                int oddCount = array.length - evenCount;
                System.out.println("Even Numbers Count: " + evenCount);
                System.out.println("Odd Numbers Count: " + oddCount);
                break;
            case 4:
                int[] reversedArray = reverseArray(array);
                System.out.print("Reversed Array: ");
                for (int num : reversedArray) {
                    System.out.print(num + " ");
                }
                break;
            case 5:
                System.out.println("Enter Factorial Number : ");
                int numForFactorial = input.nextInt(); // You can replace// this with the number for which you want to calculate the factorial
                int factorial = calculateFactorial(numForFactorial);
                System.out.println("Factorial of " + numForFactorial + ": " + factorial);
                break;
            case 6:
                System.out.println("Enter String to Check : ");
                String palindromeString = input.nextLine(); // You can replace this with the string to check for palindrome
                boolean isPalindrome = checkPalindrome(palindromeString);
                System.out.println("Is Palindrome: " + isPalindrome);
                break;
            case 7:
                System.out.println("Enter Number : ");
                int numForPrimeCheck = input.nextInt(); // You can replace this with the number to check for prime
                boolean isPrime = checkPrime(numForPrimeCheck);
                System.out.println("Is Prime: " + isPrime);
                break;
            case 8:
                System.out.println("Enter Number : ");
                int n = input.nextInt(); // You can replace this with the number of Fibonacci series elements you want
                System.out.println("Fibonacci Series:");
                printFibonacciSeries(n);
                break;
            case 9:
                System.out.println("Enter Number to Search: ");
                int searchElement = input.nextInt(); // You can replace this with the element to search in the array
                boolean found = linearSearch(array, searchElement);
                System.out.println("Element " + searchElement + " found: " + found);
                break;
            case 10:
                int[] sortedArray = array; // You can replace this with the sorted array
                Arrays.sort(sortedArray);
                System.out.println("Enter Number to Search: ");
                int binarySearchElement = input.nextInt(); // You can replace this with the element to search in the array
                int binarySearchIndex = binarySearch(sortedArray, binarySearchElement);
                System.out.println("Element " + binarySearchElement + " found at index: " + binarySearchIndex);
                break;
            case 11:
                findDuplicates(array);
                break;
            case 12:
                System.out.println("Enter String to Check : ");
                String str = input.nextLine(); // You can replace this with the string for which you want to count vowels and consonants
                countVowelsAndConsonants(str);
                break;
            case 13:
                System.out.println("Enter Number : ");
                int multiplicationTableNumber = input.nextInt(); // You can replace this with the number for which you want to print the multiplication table
                printMultiplicationTable(multiplicationTableNumber);
                break;
            case 14:
                System.out.println("Enter elements for the first matrix (5x5):");
                int[][] matrix1 = readMatrix(5, 5);

                System.out.println("Enter elements for the second matrix (5x5):");
                int[][] matrix2 = readMatrix(5, 5);

                System.out.println("Matrix 1:");
                printMatrix(matrix1);

                System.out.println("Matrix 2:");
                printMatrix(matrix2);

                int[][] sumMatrix = addMatrices(matrix1, matrix2);

                System.out.println("Sum of Matrices:");
                printMatrix(sumMatrix);
                break;
            case 15:
                findAverage(array);
                break;
            case 16:
                System.out.println("Enter Year : ");
                int leapYear = input.nextInt(); // You can replace this with the year to check for leap year
                boolean isLeap = checkLeapYear(leapYear);
                System.out.println("Is Leap Year: " + isLeap);
                break;
            case 17:
                System.out.println("Enter Row Pyramid Number : ");
                int rowNumber = input.nextInt();
                printPyramid(rowNumber);
                break;
            case 18:
                String originalString = "apple"; // You can replace this with the string to reverse
                String reversedString = reverseString(originalString);
                System.out.println("Reversed String: " + reversedString);
                break;
            case 19:
                int armstrongNumber = 153; // You can replace this with the number to check for Armstrong
                boolean isArmstrong = checkArmstrongNumber(armstrongNumber);
                System.out.println("Is Armstrong Number: " + isArmstrong);
                break;
            case 20:
                findMinMax(array);
                break;
            case 21:
                double principal = 1000;
                double rateOfInterest = 5;
                double time = 2;
                double simpleInterest = calculateSimpleInterest(principal, rateOfInterest, time);
                System.out.println("Simple Interest: " + simpleInterest);
                break;
            case 22:
                System.out.println("Enter Number : ");
                double celsius = input.nextDouble(); // You can replace this with the temperature in Celsius
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit");
                break;
            case 23:
                char inputChar = 'A'; // You can replace this with the character to check
                charTypeCheck(inputChar);
                break;
            case 24:
                // You can replace this with the array to find the second largest number
                int secondLargest = findSecondLargest(array);
                System.out.println("Second Largest Number: " + secondLargest);
                break;
            case 25:
                String stringWithNumbers = "abc123def456"; // You can replace this with the string containing numbers
                System.out.println("String is: " + stringWithNumbers);
                int sumOfNumbers = sumOfNumbersInString(stringWithNumbers);
                System.out.println("Sum of Numbers in the String: " + sumOfNumbers);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");

        }

        return 0;
    }

    // Option 1: Sum of Array Elements
    static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }


    // Option 2: Largest Element in Array
    static int findLargestElement(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Option 3: Even Numbers Count in Array
    static int countEvenNumbers(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Option 4: Reverse an Array
    static int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }
        return reversedArray;
    }

    void twoDimensionalArray() {
        int x = this.input.nextInt();
        int y = this.input.nextInt();

        int[][] array = new int[x][y];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = this.input.nextInt();
            }
        }

        System.out.println("array is " + Arrays.deepToString(array));

    }

    // Option 5: Factorial Calculation
    static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    // Option 6: Palindrome Check
    static boolean checkPalindrome(String str) {
        str = str.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Option 7: Prime Number Check
    static boolean checkPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Option 8: Fibonacci Series
    static void printFibonacciSeries(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
    }

    // Option 9: Linear Search
    static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Option 10: Binary Search
    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Element not found
    }

    // Option 11: Duplicate Elements
    // ... (previous method implementation)

    // Option 12: Count Vowels and Consonants
    static void countVowelsAndConsonants(String str) {
        str = str.toLowerCase();
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        System.out.println("Vowels Count: " + vowelsCount);
        System.out.println("Consonants Count: " + consonantsCount);
    }

    // Option 13: Multiplication Table
    static void printMultiplicationTable(int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    // Option 14: Matrix Addition
    // ... (previous method implementation)

    // Option 15: Calculate Average
    // ... (previous method implementation)

    // Option 16: Leap Year Check
    static boolean checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    // Option 17: Pattern Printing
    // ... (previous method implementation)

    // Option 18: String Reversal
    static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }

    // Option 19: Armstrong Number
    static boolean checkArmstrongNumber(int num) {
        int originalNum = num;
        int sum = 0;
        int digitCount = (int) Math.log10(num) + 1;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digitCount);
            num /= 10;
        }

        return sum == originalNum;
    }

    // Option 20: Find Minimum and Maximum
    // ... (previous method implementation)

    // Option 21: Calculate Simple Interest
    static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    // Option 22: Temperature Conversion
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Option 23: Character Type Check
    static void charTypeCheck(char ch) {
        if (Character.isUpperCase(ch)) {
            System.out.println(ch + " is an uppercase letter.");
        } else if (Character.isLowerCase(ch)) {
            System.out.println(ch + " is a lowercase letter.");
        } else if (Character.isDigit(ch)) {
            System.out.println(ch + " is a digit.");
        } else {
            System.out.println(ch + " is a special character.");
        }
    }

    // Option 24: Second Largest Number
    static int findSecondLargest(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax && num != firstMax) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    // Option 25: Sum of Numbers in a String
    static int sumOfNumbersInString(String str) {
        int sum = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }

        return sum;
    }

    static void findDuplicates(int[] arr) {

        int[] duplicateArray = new int[Integer.MAX_VALUE];

        int count = 0;

        System.out.println("Duplicates Elements Are : ");

        for (int i = 0; i < arr.length; i++) {
            if (duplicateArray[arr[i]] > 0) {
                System.out.print(arr[i] + " ");
                count++;
            }
            duplicateArray[arr[i]]++;
        }

        if (count == 0) {
            System.out.println("Nil");
        }
    }

    static void findAverage(int[] arr) {

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println("Average of the values is: " + (float) (total / arr.length));

    }

    // Function to print a pyramid pattern
    static void printPyramid(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void findMinMax(int[] arr) {

        int min = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length; i++) {

            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("Minimun value is : " + min);
        System.out.println("Maximum value is : " + max);
    }


    // Function to read a matrix from the user
    static int[][] readMatrix(int rows, int columns) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    // Function to print a matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Function to add two matrices
    static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] sumMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return sumMatrix;
    }

}
