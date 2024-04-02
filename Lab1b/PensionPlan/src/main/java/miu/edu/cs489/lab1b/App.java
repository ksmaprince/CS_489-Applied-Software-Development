package miu.edu.cs489.lab1b;

import com.google.gson.Gson;
import miu.edu.cs489.lab1b.model.Employee;
import miu.edu.cs489.lab1b.model.PensionPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    //Feature 1
    private static String employeesJSON(List<Employee> employees){
        employees.sort(
                Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getYearlySalary).reversed()
        );
        return new Gson().toJson(employees);
    }

    private static String enrollmentReport(List<Employee> employees){
        return "";
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Daniel", "Agar", "2018-01-17", 105945.50, new PensionPlan("EX1089", "2023-01-17", 100.0)));
        employees.add(new Employee(2L, "Bernard", "Shaw", "2018-10-03", 197750.00, new PensionPlan(null, null, null)));
        employees.add(new Employee(3L, "Carly", "Agar", "2014-05-16", 842000.75, new PensionPlan("SM2307", "2019-11-04", 1555.50)));
        employees.add(new Employee(4L, "Wesley", "Schneider", "2018-11-02", 74500.00, new PensionPlan(null, null, null)));


        System.out.println(employeesJSON(employees));

    }
}