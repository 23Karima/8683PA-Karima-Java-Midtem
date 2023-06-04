package company_app_design;

public class CompanyEmployee {

    /** INSTRUCTIONS
     *
     *  This class has a main method where you will be able to create instances of the EmployeeInfo class in order
     *  to use attributes and methods.
     *
     *  Demonstrate as many methods as possible here. Feel free to show off what you've learned so far.
     *
     *  The goal of this application is to provide basic employee information services
     *  Try to think like a Software Developer
     */
    public static void main(String[] args) {
        // Create an instance of EmployeeInfo
        EmployeeInfo employeeInfo = new EmployeeInfo(1254874521, "7117 Sanlin dr");
        System.out.println("Employee address: " + employeeInfo.getEmployeeAddress());
        employeeInfo.setEmployeeAddress("1920 Solly Ave");// update employee address.
        System.out.println("Updated employee address: " + employeeInfo.getEmployeeAddress());

        // Calculate annual bonus
        double annualBonus = EmployeeInfo.calculateAnnualBonus(4000, 3);
        System.out.println("Annual bonus: " + annualBonus);

        // Create an instance of EmployeeInfo of name, ID, and gross salary
        EmployeeInfo emp1 = new EmployeeInfo("Karima", 300500, 40000.00);
        System.out.println("Employee name: " + emp1.getEmployeeName());
        System.out.println("Employee ID: " + emp1.getEmployeeId());
        System.out.println("Employee gross salary: " + emp1.getGrossSalary());

        // Calculate net salary
        double netSalary = emp1.calculateNetSalary(40000, 0.3, 4000);
        System.out.println("Net salary: " + netSalary);

        // Calculate employee pension
        int pension = EmployeeInfo.calculateEmployeePension();
        System.out.println("Employee pension: " + pension);

        // Get the number of years
        int years = EmployeeInfo.getNumberOfYears("May,2011", "August,2023");
        System.out.println("Number of years: " + years);

        // Create an instance of EmployeeInfo using default constructor
        EmployeeInfo employeeInf = new EmployeeInfo();

        // Calculate salary and benefits
        System.out.println("Salary: " + employeeInf.calculateSalary());
        System.out.println("Benefits: " + employeeInf.benefits());

        // Create an instance of EmployeeInfo with ID only
        EmployeeInfo employeeA = new EmployeeInfo(7855);
        System.out.println("Employee ID: " + employeeA.employeeId());

        // Create an instance of EmployeeInfo with name only
        EmployeeInfo employeeB = new EmployeeInfo("Karima");
        System.out.println("Employee name: " + employeeB.employeeName());

        // Assign department
        System.out.println("Assigned department: " + employeeInf.assignDepartment());

        // Get the month index
        int monthIndex = EmployeeInfo.whichMonth("Ma");
        System.out.println("Month index: " + monthIndex);
    }
}
