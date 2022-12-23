import homework3.animals.Cat;
import homework3.animals.Dog;

public class Main {
    public static void main(String[] args) {
        Cat catMur = new Cat("Mur");
        catMur.run(300);
        catMur.swim(10);
        Cat catNuri = new Cat("Nuri");
        catNuri.run(140);
        Dog dogJonny = new Dog("Jonny");
        dogJonny.run(300);
        dogJonny.swim(1);
        Dog dogTusik = new Dog("Tusik");
        dogTusik.run(-333);
        dogTusik.swim(133);
        catMur.getGeneralNumberAnimals();
    }
}