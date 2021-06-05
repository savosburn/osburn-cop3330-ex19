/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex19;

import java.util.Scanner;

/*
You’ll often need to see if one value is within a certain range and alter the flow of a program as a result.

Create a program to calculate the body mass index (BMI) for a person using the person’s height in inches and weight in
pounds. The program should prompt the user for weight and height.

Calculate the BMI by using the following formula:

bmi = (weight / (height × height)) * 703
If the BMI is between 18.5 and 25, display that the person is at a normal weight.
If they are out of that range, tell them if they are underweight or overweight and tell them to consult their doctor.

Example Output
Your BMI is 19.5.
You are within the ideal weight range.
or

Your BMI is 32.5.
You are overweight. You should see your doctor.
Constraint
Ensure your program takes only numeric data. Don’t let the user continue unless the data is valid.
 */

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        double height = myApp.readHeight();
        double weight = myApp.readWeight();
        double bmi = myApp.calculateBMI(height, weight);

        String outputString = myApp.generateString(bmi);
        myApp.output(outputString);
    }

    public double readHeight() {
        //double number;

        /*
        while(!in.hasNextDouble()) {
            System.out.print("Please enter your height in inches: ");

            if () {
                System.out.printf("Invalid number. Please try again.\n");
                scan.next();
            }

            number = in.nextDouble();
            return number;
        }*/

        System.out.print("Please enter your height in inches: ");
        while(!in.hasNextInt()) {
            System.out.printf("Invalid number. Please try again.\n");
            in.next();
        }
        double number = in.nextDouble();

        return number;
    }

    public double readWeight() {

        System.out.print("Please enter your weight in pounds: ");
        while(!in.hasNextInt()) {
            System.out.printf("Invalid number. Please try again.\n");
            in.next();
        }
        double number = in.nextDouble();

        return number;
    }

    public double calculateBMI(double height, double weight) {
        return (weight / (height * height)) * 703;
    }

    public String generateString(double bmi) {
        String str1 = String.format("Your BMI is %.1f", bmi);
        String str2 = null;

        if (bmi < 18.5) {
            str2 = "You are underweight. You should see your doctor.";
        } else if (bmi < 25) {
            str2 = "Your weight is normal.";
        } else {
            str2 = "You are overweight. You should see your doctor.";
        }

        return str1 + str2;
    }

    public void output(String outputString) {
        System.out.println(outputString);
    }
}
