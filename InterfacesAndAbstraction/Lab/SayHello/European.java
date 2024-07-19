package OOP.InterfacesAndAbstraction.Lab.SayHello;

public class European implements Person{
    public European(String name) {
        this.name = name;
    }

    private String name;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
