import java.util.Scanner;

/*
Name:Alexander Crowe
Class:Data Structures 210
Assignment:Assignment 1 coding challenge 17: 2D Array's.

This program is not only designed to do the requested but also accepts data inputs
for the matrix and will print the formatted matrix in the console return.

*/





public class Project 
{   

    /*  These variables are 
        global private variables so no constructor 
        has to be made and they are usable in all
        methods.
    */
    private static final int ROW = 5;
    private static final int COL = 5;

    /* The main method allows you to enter data
        yourself rather than changing the data  
        inside the actual program.
    */
    public static void main(final String[] args)
    {

        int total = 0;
        double avg = 0;
        int rowTotal = 0;
        int colTotal = 0;
        int maxRow = 0;
        int lowRow = 0;

        final int myArray[][] =  new int[ROW][COL];
       
        final Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < ROW; i++ )
        {
            for(int j = 0; j < COL; j++)
            {
                System.out.print("Input for Row " + (i+1) + " and Column " + (j+1) + ": ");
                myArray[i][j] = keyboard.nextInt();

                
            }
        }
        /* Inside the main method I call the prints
        for each variable and store all the variables
        should I want to expand the program
        */
        printArray(myArray);
        total = getTotal(myArray);
        avg = getAverage(myArray);
        rowTotal = getRowTotal(myArray, 1);
        colTotal = getColTotal(myArray, 4);
        maxRow = getHighestInRow(myArray, 1);
        lowRow = getLowestInRow(myArray, 1);

        System.out.println("Total: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Row 2 Total: " + rowTotal );
        System.out.println("Column 5 Total: " + colTotal);
        System.out.println("Highest in Row 2: " + maxRow);
        System.out.println("Lowest in Row 2: " + lowRow);
        keyboard.close();
    }
    /*To print the array I create a temp variable
     to store the amount of numbers I have placed
     to format it in a print array.
     This is primarily used for debugging.
     */
    public static void printArray(final int array[][]) {

        for (int i = 0; i < ROW; i++) {
            int temp = 0;
            for (int j = 0; j < COL; j++) {
                if (temp < 4) {
                    System.out.print(array[i][j] + ", ");
                    temp++;
                } else if (temp == 4) {
                    temp = 0;
                    System.out.println(array[i][j]);
                }
            }
        }

    }

    /*
     * To get the total all I do is iterate through each column in the first row and
     * when ive reached the end of the row I go to the next row.
     */
    public static int getTotal(final int array[][]) {
        int total = 0;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                total += array[i][j];
            }

        }
        return total;
    }

    /*
     * To get the average we simply copy the getTotal method and the divide by the
     * Row multiplied by the column's because the total number of elements are a
     * square. Another way to do this would be to add one to a variable called
     * cellNum and iterate through the ROW and COL variables one by one and then
     * take the total of all the numbers in the matrix and then divide it by the
     * cellNum to get the Avg/
     */
    public static double getAverage(final int array[][]) {
        double total = 0;
        double avg;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                total += array[i][j];
            }

        }
        avg = total / (ROW * COL);
        return avg;
    }

    /*
     * Starting a row total variable at 0 and iterating through the row given in the
     * method call and adding it to itself.
     */

    public static int getRowTotal(final int array[][], final int n) {
        int rowTotal = 0;
        for (int i = 0; i < COL; i++) {
            rowTotal += array[n][i];
        }
        return rowTotal;
    }

    /*
     * The same way we got the row total is the same way we get the column total.
     * The only difference is we iterate through the row we decide from the method
     * call and add the column's together.
     * 
     */
    public static int getColTotal(final int array[][], final int n) {
        int colTotal = 0;
        for (int i = 0; i < ROW; i++) {
            colTotal += array[n][i];
        }
        return colTotal;
    }

    /*
     * To get the highest in the row we must start with the first data member in the
     * given row. We then check if the next number in the iteration is higher. If it
     * is we set it as the highest in the row. If not, we ignore it and iterate to
     * the next number in the row.
     */
    public static int getHighestInRow(final int array[][], final int n) {
        int highest = array[n][0];
        for (int i = 0; i < COL; i++) {
            if (array[n][i] > highest) {
                highest = array[n][i];
            }
        }
        return highest;
    }

    /*
     * We do the exact same thing to find the highest except we change the variable
     * names for readability and then flip the greater than to less than in the
     * decision statement. This allows us to find the lowest in the row.
     */
    public static int getLowestInRow(final int array[][], final int n)
    {
        int lowest = array[n][0];
        for(int i = 0; i < COL; i++)
        {
            if(array[n][i] < lowest)
            {
                lowest = array[n][i];
            }
        }
        return lowest;
    }
}
