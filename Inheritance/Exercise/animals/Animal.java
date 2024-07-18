package OOP.Inheritance.Exercise.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        isValid(name.isBlank() || name.isEmpty());
        this.name = name;
    }

    public void setAge(int age) {
        isValid(age < 0);
        this.age = age;
    }

    public void setGender(String gender) {
        isValid(gender.isEmpty() || gender.isBlank());
        this.gender = gender;
    }

    public String produceSound(){
        return null;
    }

    @Override
    public String toString() {
        String output = this.getClass().getSimpleName() + System.lineSeparator();
        output += getName()+" " + getAge() + " " + getGender() + System.lineSeparator();
        output+= produceSound();
        return output;
        // StringBuilder sb = new StringBuilder();
        //
        //        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        //        sb.append(getName()).append(" ").append(getAge()).append(" ").append(getGender()).append(System.lineSeparator());
        //        sb.append(produceSound());
        //
        //        return sb.toString();
    }

    private static void isValid(boolean name) {
        if (name) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
}
