package homework3.animals;

public abstract class Animal {
    private String name;
    private String type;

    private int runRestriction;
    private int swimRestriction;

    private static int numberAnimals = 0;
    private static int numberCats = 0;
    private static int numberDogs = 0;

    protected Animal(String name, String type, int runRestriction, int swimRestriction) {
        this.name = name;
        this.type = type;
        this.runRestriction = runRestriction;
        this.swimRestriction = swimRestriction;
        this.countAnimals();
    }

    private void countAnimals() {
        ++Animal.numberAnimals;
        if (this.type.equals("cat")) {
            ++Animal.numberCats;
        }
        if (this.type.equals("dog")) {
            ++Animal.numberDogs;
        }
    }


    public void getGeneralNumberAnimals() {
        System.out.println("number Animals " + Animal.numberAnimals);
        System.out.println("number Cats " + Animal.numberCats);
        System.out.println("number Dogs " + Animal.numberDogs);
    }

    public void run(int length) {
        if (length <= 0) return;
        if (length <= this.runRestriction) {
            System.out.println(this.name + " run " + length + " meters");
        } else {
            System.out.println("its impossible, so many meters run for " + this.type);
        }
    }

    public void swim(int length) {
        if (length <= 0 || this.swimRestriction == 0) return;
        if (length <= this.swimRestriction) {
            System.out.println(this.name + " swim " + length + " meters");
        } else {
            System.out.println("its impossible, so many meters swim for " + this.type);
        }
    }
}
