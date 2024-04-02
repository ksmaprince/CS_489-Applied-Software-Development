package miu.edu.cs489.lab1b;

import com.google.gson.Gson;
import miu.edu.cs489.lab1b.model.Employee;
import miu.edu.cs489.lab1b.model.PensionPlan;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.util.*;

public class App {
    //Feature 1
    private static String employeesJSON(List<Employee> employees){
        employees.sort(
                Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearlySalary).reversed()
        );
        return new Gson().toJson(employees);
    }

    private static String enrolleeReport(List<Employee> employees){
        List<Employee> employeewWhoQualifiedPension = new ArrayList<>();

        employees.forEach(employee -> {
            String employmentDate = employee.getEmploymentDate();
            LocalDate empdate = LocalDate.parse(employmentDate);

            LocalDate today = LocalDate.now();
            YearMonth nextMonth = YearMonth.from(today).plusMonths(1);
            LocalDate endOfMonth = nextMonth.atEndOfMonth();

            Period period = Period.between(empdate,endOfMonth);

            if (period.getYears() >= 5){
                employeewWhoQualifiedPension.add(employee);
            }
        });

        employeewWhoQualifiedPension.sort(Comparator.comparing(Employee::getEmploymentDate));

        return new Gson().toJson(employeewWhoQualifiedPension);
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Daniel", "Agar", "2018-01-17", 105945.50, new PensionPlan("EX1089", "2023-01-17", 100.0)));
        employees.add(new Employee(2L, "Bernard", "Shaw", "2018-10-03", 197750.00, new PensionPlan(null, null, null)));
        employees.add(new Employee(3L, "Carly", "Agar", "2014-05-16", 842000.75, new PensionPlan("SM2307", "2019-11-04", 1555.50)));
        employees.add(new Employee(4L, "Wesley", "Schneider", "2018-11-02", 74500.00, new PensionPlan(null, null, null)));

        System.out.println("List of All Employees: ");
        System.out.println(employeesJSON(employees));
        System.out.println("Monthly Upcoming Enrollees: ");
        System.out.println(enrolleeReport(employees));

    }
}