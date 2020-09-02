package Animals;

public class Cat extends Animal {
    public String Name;
    public Gender Gender;
    public String BadHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.BadHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + this.BadHabits.toLowerCase();
    }
}
