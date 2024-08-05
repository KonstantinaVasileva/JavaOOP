package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WorkingImpl implements Working {
    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        Collection<String> orders = client.getClientOrders();

        for (Waiter waiter : waiters) {
            List<String> orderForRemove = new ArrayList<>();
            boolean canWork = true;
            for (String order : orders) {
                if (!canWork){
                    break;
                }
                waiter.work();
                waiter.takenOrders().getOrdersList().add(order);
                orderForRemove.add(order);
                if (!waiter.canWork()){
                    canWork = false;
                }
            }
            orders.removeAll(orderForRemove);
        }
    }
}
