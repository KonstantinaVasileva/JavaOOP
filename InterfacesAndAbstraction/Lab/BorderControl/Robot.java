package OOP.InterfacesAndAbstraction.Lab.BorderControl;

public class Robot implements Identifiable {
    private String id;
    private String model;

    public Robot(String model, String id) {
        this.id = id;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public String getId() {
        return id;
    }


}
