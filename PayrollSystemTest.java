// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.
/**********************************************************
 *                                                        *
 *  CSCI 470/502        Assignment 5         Summer 2021  *
 *                                                        *
 *  Developer(s):  Leonart Jaos
 *                                                        *
 *  Section:  0Y01                                        *
 *                                                        *
 *  Due Date/Time:  The assignment due date and time here *
 *                                                        *
 *  Purpose:  The below application represents an employee*
 *  payroll system. An employee is an Abstract class that *
 *  has many subtypes represented as classes. This app is *
 *  meant as a demonstration of polymorphism, that is, the*
 *  overriding of functions in subclasses so that when re-*
 *  ferred to as an instance of its parent class, it perf-*
 *  orms the same functions. Employee member functions are*
 *  printed, and if their birthday happens to be in the m-*
 *  onth of payroll, they're earnings are increased by an *
 *  amount of $100.                                       *
 *                                                        *
 **********************************************************/


import java.util.Scanner;

public class PayrollSystemTest
{
   public static void main(String[] args) 
   {
      // create subclass objects
      // create date object for salaried employee constructor
      Date bDay = new Date(6,15,1944);
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee("John", "Smith", "111-11-1111", bDay, 800.00);
      // create date object for hourly employee constructor
      bDay = new Date(12,29,1960);
      HourlyEmployee hourlyEmployee =
         new HourlyEmployee("Karen", "Price", "222-22-2222", bDay, 16.75, 40);
      // create date object for commission employee constructor
      bDay = new Date(9,8,1954);
      CommissionEmployee commissionEmployee =
         new CommissionEmployee(
         "Sue", "Jones", "333-33-3333", bDay, 10000, .06);
      // create date object for base plus commission employee constructor
      bDay = new Date(3,2,1965);
      BasePlusCommissionEmployee basePlusCommissionEmployee =
         new BasePlusCommissionEmployee(
         "Bob", "Lewis", "444-44-4444", bDay,5000, .04, 300);

      System.out.println("Employees processed individually:");
      
      System.out.printf("%n%s%n%s: $%,.2f%n%n", 
         salariedEmployee, "earned", salariedEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         hourlyEmployee, "earned", hourlyEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n",
         commissionEmployee, "earned", commissionEmployee.earnings());
      System.out.printf("%s%n%s: $%,.2f%n%n", 
         basePlusCommissionEmployee, 
         "earned", basePlusCommissionEmployee.earnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = basePlusCommissionEmployee;

      // input for current month of payroll
      int month;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the current month (1 - 12): ");
      month = input.nextInt();
      System.out.printf("Employees processed polymorphically:%n%n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) 
      {
         System.out.println(currentEmployee); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee)
         {
            // downcast Employee reference to
            // BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee =
                    (BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            System.out.printf(
                    "new base salary with 10%% increase is: $%,.2f%n",
                    employee.getBaseSalary());
         }

         // if current payroll month is employee birthday month, increase pay by 100
         if (currentEmployee.getBirthDate().getMonth() == month)
         {
            System.out.printf(
                    "earned $%,.2f%s%n%n", currentEmployee.earnings(), " plus a $100.00 birthday bonus");
         }
         else
         {
            System.out.printf(
                    "earned $%,.2f%n%n", currentEmployee.earnings());
         }
      } 

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++)
         System.out.printf("Employee %d is a %s%n", j, 
            employees[j].getClass().getName()); 
   } // end main
} // end class PayrollSystemTest

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
