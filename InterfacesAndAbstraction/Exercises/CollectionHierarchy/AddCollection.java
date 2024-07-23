package OOP.InterfacesAndAbstraction.Exercise.CollectionHierarchy;

public class AddCollection extends Collection implements Addable{
    public AddCollection(){
        super();
    }

    @Override
    public int add(String item) {
        items.add(item);
        return items.indexOf(item);
    }
}
