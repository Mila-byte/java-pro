package employee;

public class Employee {
    private String name;
    private String position;
    private String email;
    private Number phone;
    private Number age;

    public Employee(String name, String position, String email, Number phone, Number age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public void getInfoEmployee() {
        System.out.println("name: " + this.name + ", position: " + this.position + ", email: " + this.email + ", phone: " + this.phone + ", age: " + this.age);
    }
}
