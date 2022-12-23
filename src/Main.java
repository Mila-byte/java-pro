import car.Car;
import employee.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Some Name", "top", "somename@gmail.com", 2343636, 43);
        employee.getInfoEmployee();
        Employee employee2 = new Employee("Some Name", "no top", "somename2@gmail.com", 36363, 36);
        employee2.getInfoEmployee();

        Car car = new Car();
        System.out.println("name class: " + car.getClass().getSimpleName());
    }
}