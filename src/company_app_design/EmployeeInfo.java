package company_app_design;

import java.util.Scanner;

public class EmployeeInfo extends EmployeeImplementation{

    /**
     * INSTRUCTIONS
     * <p>
     * This class should implement the Employee interface, but you must do that without using the keyword `implements`
     * anywhere in this class.
     * <p>
     * HINT: Take a look at the collections framework diagram. Do you see how a class may implement an interface without
     * directly implementing it?
     * <p>
     * YOU MUST USE/DO:
     * OOP (Abstraction, Encapsulation, Inheritance and Polymorphism) concepts in every way possible
     * Use all kind of keywords (super, this, static, final, etc)
     * Implement nested class below (DateConversion)
     * Use Exception Handling
     * <p>
     * Once you're done with designing this EmployeeInfo class, go to the CompanyEmployee class to test
     */

    // Make sure to declare and use static, non-static & final fields

    private int employeeId;
    private String employeeName;
    private double grossSalary;
    private String employeeAddress;
    public String department;
    static final String companyName = "Tesla";
    private int id;

    private long employeeSSN;

    // You must have/use multiple constructors to initialize instance variables that you will create above

    public EmployeeInfo(String employeeName, int employeeId, double grossSalary){
        this.employeeName=employeeName;
        this.employeeId=employeeId;
        this.grossSalary=grossSalary;
    }
    public EmployeeInfo(long employeeSSN, String employeeAddress) {
        this.employeeAddress = employeeAddress;
        this.employeeSSN = employeeSSN;

    }
    public EmployeeInfo(String employeeName){
        this.employeeName=employeeName;
    }

    public EmployeeInfo(int employeeId) {
        this.employeeId = employeeId;

    }

    public EmployeeInfo() {

    }


    /*
    You need to implement the logic of this method as such:

        It should calculate employee bonus based on salary and performance.
        It should return the total yearly bonus

        e.g. - Bonus = 10% of yearly salary for best performance
               Bonus = 6% of yearly salary for average performance, etc.
     */
    public static int calculateAnnualBonus(int salary, int performanceGrade) {
        int total = 0;
        if (performanceGrade == 1) {
            total = (int) (salary * 0.1);
        } else if (performanceGrade == 2) {
            total = (int) (salary * 0.06);
        } else if (performanceGrade == 3) {
            total = (int) (salary * 0.03);
        } else {
            total = 0;
        }

        return total;
    }

    /*
    You need to implement the logic of this method as such:

    It should calculate employee pension based on salary and numbers of years spent with the company.
    It should return the total pension amount.

    e.g. - Employee will receive 5% of salary as pension for every year they are with the company
     */
    public static int calculateEmployeePension() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter start date in format (example: May,2015): ");
        String joiningDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        if(convertedJoiningDate.isEmpty()){
            return 0;
        }
        System.out.println("Please enter today's date in format (example: August,2017): ");
        String todaysDate = sc.nextLine();
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);
        if(convertedTodaysDate.isEmpty()){
            return 0;
        }
        int salary = 0;
        System.out.println("Please enter your salary: ");
        try {
            salary = sc.nextInt();
        }
        catch(Exception e){
            System.out.println("This is not a valid salary");
            return 0;
        }
        // Figure out how to extract the number of years the employee has been with the company, using the above 2 dates
        // Calculate pension
        return total;
    }
    public static int getNumberOfYears(String date1, String date2){
        String[] extractDate1 = date1.split("/");
        String[] extractDate2 = date2.split("/");
        int month1 = Integer.parseInt(extractDate1[0]);
        int month2 = Integer.parseInt(extractDate2[0]);
        int year1 = Integer.parseInt(extractDate1[1]);
        int year2 = Integer.parseInt(extractDate2[1]);
        int yearDifference =  year2 - year1;
        if(month2 < month1)
            yearDifference -= 1;
        return yearDifference;
    }

    @Override
    public int employeeId() {
        return this.employeeId;
    }

    @Override
    public String employeeName() {

        return this.employeeName;
    }

    @Override
    public String assignDepartment() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Please enter your valid ID");
        int employeeId = sc.nextInt();

        if( id<= 100) {
            department = "Department of logistics";
        }else if(id>=101 && id<=300){
            department="department of engineering";
        }else if(id>=301 && id<=600){
            department="Department of design";
        }else{
            department ="Department Unkown";

        }
        return "Your department is:" +department;

    }

    @Override
    public int calculateSalary() {

        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter your grossPay");
        int grossPay = stdin.nextInt();
        int payPeriodPerYear = 12;
        System.out.print("Your salary is ");
        return grossPay * payPeriodPerYear;
    }

    @Override
    public double benefits() {
        int salary = 60000;
        double benefitPercentage =0.1;
        double benefits = salary*benefitPercentage;
        System.out.println("The benefits of this emplyee salary is: " + benefits);
        return benefitPercentage;
    }



    private static class DateConversion {

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);

            String actualDate = monthDate + "/" + extractMonth[1];
            return actualDate;
        }
    }

    public static int whichMonth(String givenMonth) {
        Months month = Months.valueOf(givenMonth);
        int monthNumber;

        switch (month) {
            case January:
                monthNumber = 1;
                break;
            case February:
                monthNumber = 2;
                break;
            case March:
                monthNumber = 3;
                break;
            case April:
                monthNumber = 4;
                break;
            case May:
                monthNumber = 5;
                break;
            case June:
                monthNumber = 6;
                break;
            case July:
                monthNumber = 7;
                break;
            case August:
                monthNumber = 8;
                break;
            case September:
                monthNumber = 9;
                break;
            case October:
                monthNumber = 10;
                break;
            case November:
                monthNumber = 11;
                break;
            case December:
                monthNumber = 12;
                break;
            default:
                monthNumber = -1;
                break;
        }
        return monthNumber;
    }

    //Encapsulation
    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public long getEmployeeSSN() {
        return employeeSSN;
    }

    public void setEmployeeSSN(long employeeSSN) {
        this.employeeSSN = employeeSSN;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double calculateNetSalary(double grossSalary, double taxRate, double deductions) {
        double netSalary = grossSalary - (grossSalary * taxRate) - deductions;
        return netSalary;
    }
}