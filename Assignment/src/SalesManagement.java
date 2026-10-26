
import java.util.Scanner;

public class SalesManagement {

    public static Scanner input = new Scanner(System.in);

    static String[] arPersons = new String[4];
    static double[][] arSales = new double[4][4];

    static String selectedName = "";

    // Initialize the arrays
    public static void Initialize() {

        arPersons[0] = "Thabo";
        arPersons[1] = "Loraine";
        arPersons[2] = "Zama";
        arPersons[3] = "Peter";

        arSales[0][0] = 17550;
        arSales[0][1] = 14500;
        arSales[0][2] = 11000;
        arSales[0][3] = 12500;

        arSales[1][0] = 15000;
        arSales[1][1] = 12000;
        arSales[1][2] = 12500;
        arSales[1][3] = 16800;

        arSales[2][0] = 15620;
        arSales[2][1] = 18100;
        arSales[2][2] = 21500;
        arSales[2][3] = 17630;

        arSales[3][0] = 15755;
        arSales[3][1] = 13900;
        arSales[3][2] = 12950;
        arSales[3][3] = 19200;
    }

    // Find a salesperson by name
    public static int findSalesPerson(String name) {

        for (int i = 0; i < arPersons.length; i++) {

            if (arPersons[i].equalsIgnoreCase(name)) {
                return i;
            }
        }

        return -1;
    }

    // Calculate total monthly sales
    public static double calcTotalMonthlySales() {

        int position = findSalesPerson(selectedName);

        if (position == -1) {
            return 0;
        }

        double total = 0;

        for (int i = 0; i < arSales[position].length; i++) {
            total += arSales[position][i];
        }

        return total;
    }

    // Calculate monthly salary
    public static double calcMonthlySalary() {

        double monthlySales = calcTotalMonthlySales();

        return 7500 + (monthlySales * 0.10);
    }

    // Calculate monthly turnover
    public static double calcMonthlyTurnOver() {

        double turnover = 0;

        for (int i = 0; i < arPersons.length; i++) {

            for (int j = 0; j < arSales[i].length; j++) {
                turnover += arSales[i][j];
            }
        }

        return turnover;
    }

    // Calculate total salary expenditure
    public static double calcSalaryExpenditure() {

        double expenditure = 0;

        for (int i = 0; i < arPersons.length; i++) {

            selectedName = arPersons[i];

            expenditure += calcMonthlySalary();
        }

        return expenditure;
    }

    // Find and display the best salesperson
    public static void getBestSalesPerson() {

        int bestPosition = 0;
        double highestSales = 0;

        for (int i = 0; i < arPersons.length; i++) {

            selectedName = arPersons[i];

            double monthlySales = calcTotalMonthlySales();

            if (monthlySales > highestSales) {
                highestSales = monthlySales;
                bestPosition = i;
            }
        }

        System.out.println("Best Salesperson");
        System.out.println(arPersons[bestPosition] + "     "
                + highestSales);
    }

    // Display all salespeople
    public static void display() {

        System.out.println("Name       Week 1     Week 2     Week 3"
                + "     Week 4     Total Sales");

        System.out.println("------------------------------------------------"
                + "------------------");

        for (int i = 0; i < arPersons.length; i++) {

            double total = 0;

            for (int j = 0; j < arSales[i].length; j++) {
                total += arSales[i][j];
            }

            System.out.printf("%-11s", arPersons[i]);

            for (int j = 0; j < arSales[i].length; j++) {
                System.out.printf("%-11.1f", arSales[i][j]);
            }

            System.out.printf("%.0f%n", total);
        }
    }

    // Display the menu
    public static void displayMenu() {

        System.out.println("\nPlease select a menu item below:");
        System.out.println("1 - See All Salespeople");
        System.out.println("2 - Find Salesperson");
        System.out.println("3 - Total Monthly Sales");
        System.out.println("4 - Monthly Salary");
        System.out.println("5 - Best Salesperson");
        System.out.println("6 - Monthly Turnover");
        System.out.println("7 - Total Salary Expenditure");
        System.out.print("Your Option: ");
    }

    // Main method
    public static void main(String[] args) {

        Initialize();

        String choice;

        do {

            displayMenu();

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:

                    display();
                    break;

                case 2:

                    System.out.print("Search for salesperson: ");
                    selectedName = input.nextLine();

                    int position = findSalesPerson(selectedName);

                    if (position != -1) {
                        System.out.println(selectedName + " is found at "
                                + (position + 1));
                    } else {
                        System.out.println("Salesperson not found");
                    }

                    break;

                case 3:

                    System.out.print("Search for salesperson: ");
                    selectedName = input.nextLine();

                    if (findSalesPerson(selectedName) != -1) {
                        System.out.println("Total Sales for "
                                + selectedName + ": "
                                + calcTotalMonthlySales());
                    } else {
                        System.out.println("Salesperson not found");
                    }

                    break;

                case 4:

                    System.out.print("Search for salesperson: ");
                    selectedName = input.nextLine();

                    if (findSalesPerson(selectedName) != -1) {
                        System.out.println("Monthly Salary for "
                                + selectedName + ": "
                                + calcMonthlySalary());
                    } else {
                        System.out.println("Salesperson not found");
                    }

                    break;

                case 5:

                    getBestSalesPerson();
                    break;

                case 6:

                    System.out.println("Monthly Turnover: "
                            + calcMonthlyTurnOver());
                    break;

                case 7:

                    System.out.println("Salary Expenditure "
                            + calcSalaryExpenditure());
                    break;

                default:

                    System.out.println("Invalid menu option.");
            }

            System.out.print("Do you want to continue? (Y/N)");
            choice = input.nextLine();

        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Program ended.");
        input.close();
    }
}
