package OOP.Encapsulation.Lab.FirstAndReserveTeam_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addPlayer(Person person){
        if (person.getAge() < 40){
            firstTeam.add(person);
        } else {
            reserveTeam.add(person);
        }
    }
    public List<Person> getFirstTeam(){
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person> getReserveTeam(){
        return Collections.unmodifiableList(this.reserveTeam);
    }
}
