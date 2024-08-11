import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

interface Employee {
    double getMonthSalary();
}

class Operator implements Employee {
    private final double fixedSalary;

    public Operator(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary;
    }
}

class Manager implements Employee {
    private final double fixedSalary;
    private final double bonusPercent;
    private final double companyIncome;

    public Manager(double fixedSalary, double bonusPercent) {
        this.fixedSalary = fixedSalary;
        this.bonusPercent = bonusPercent;
        this.companyIncome = new Random().nextInt(30001) + 110000;
    }

    @Override
    public double getMonthSalary() {
        return fixedSalary + (companyIncome * bonusPercent);
    }
}

class TopManager implements Employee {
    private final double fixedSalary;
    private final double bonusPercentage;
    private final double companyIncomeThreshold;

    public TopManager(double fixedSalary, double bonusPercentage, double companyIncomeThreshold) {
        this.fixedSalary = fixedSalary;
        this.bonusPercentage = bonusPercentage;
        this.companyIncomeThreshold = companyIncomeThreshold;
    }

    @Override
    public double getMonthSalary() {
        return companyIncomeThreshold > 10_000_000 ? fixedSalary + bonusPercentage * fixedSalary : fixedSalary;
    }
}

class Company {
    private final List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeeList) {
        employees.addAll(employeeList);
    }

    public void fire(int count) {
        for (int i = 0; i < count && !employees.isEmpty(); i++) {
            employees.remove(0);
        }
    }

    public double getIncome() {
        double totalIncome = 0;
        for (Employee employee : employees) {
            totalIncome += employee.getMonthSalary();
        }
        return totalIncome;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort((e1, e2) -> Double.compare(e2.getMonthSalary(), e1.getMonthSalary()));
        return getSubListOrWholeList(sortedEmployees, count);
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        sortedEmployees.sort(Comparator.comparingDouble(Employee::getMonthSalary));
        return getSubListOrWholeList(sortedEmployees, count);
    }

    private List<Employee> getSubListOrWholeList(List<Employee> list, int count) {
        if (count <= 0) {
            return new ArrayList<>(list);
        }
        return list.subList(0, Math.min(count, list.size()));
    }
}


public class CompanyBase {
    public static void main(String[] args) {
        Company company = new Company();

        // Hire employees
        List<Employee> operators = generateOperators(180);
        List<Employee> managers = generateManagers(80);
        List<Employee> topManagers = generateTopManagers(10);

        company.hireAll(operators);
        company.hireAll(managers);
        company.hireAll(topManagers);

        // Print top and lowest salaries
        printSalaries("Top Salaries", company.getTopSalaryStaff(15));
        printSalaries("Lowest Salaries", company.getLowestSalaryStaff(30));

        // Fire 50% of employees
        company.fire((int) (company.getIncome() / 2));

        // Print top and lowest salaries after firing
        printSalaries("Top Salaries after firing", company.getTopSalaryStaff(15));
        printSalaries("Lowest Salaries after firing", company.getLowestSalaryStaff(30));
    }

    private static List<Employee> generateOperators(int count) {
        List<Employee> operators = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            operators.add(new Operator(80_000));
        }
        return operators;
    }

    private static List<Employee> generateManagers(int count) {
        List<Employee> managers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            managers.add(new Manager(100_000, 0.05));
        }
        return managers;
    }

    private static List<Employee> generateTopManagers(int count) {
        List<Employee> topManagers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            topManagers.add(new TopManager(150_000, 1.5, 10_000_000));
        }
        return topManagers;
    }

    private static void printSalaries(String title, List<Employee> employees) {
        System.out.println(title + ":");
        for (Employee employee : employees) {
            System.out.println(String.format("• %.2f руб.", employee.getMonthSalary()));
        }
        System.out.println();
    }
}
