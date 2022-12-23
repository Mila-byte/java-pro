package car;

public class Car {
    public Car() {
        this.startElectricity();
        this.startCommand();
        this.startFuelSystem();
    }
    private void startElectricity() {
        System.out.println("start electricity");
    }

    private void startCommand() {
        System.out.println("start command");
    }

    private void startFuelSystem() {
        System.out.println("start fuel system");
    }
}
