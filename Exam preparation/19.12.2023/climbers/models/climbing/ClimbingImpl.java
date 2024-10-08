package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClimbingImpl implements Climbing{
    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        Collection<String> peaksList = mountain.getPeaksList();
        for (Climber climber : climbers) {
            while (climber.canClimb() && peaksList.iterator().hasNext()){
                String peak = peaksList.iterator().next();
                climber.getRoster().getPeaks().add(peak);
                climber.climb();
                peaksList.remove(peak);
            }
        }
    }
}
