package OOP.Inheritance.Lab.RandomArrayList_03;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Integer> {


    public Object getRandomElement(){
        int size = size();
        Random random = new Random();
        int index = random.nextInt(size);
        return get(index);
    }
}
