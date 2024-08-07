package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> seaCreatures = divingSite.getSeaCreatures();
        for (Diver diver : divers) {
            if (diver.canDive() && seaCreatures.iterator().hasNext()){
                String creature = seaCreatures.iterator().next();
                diver.shoot();
                diver.getSeaCatch().getSeaCreatures().add(creature);
                seaCreatures.remove(creature);
            }
        }
    }
}
