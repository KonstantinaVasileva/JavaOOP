package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;

//TODO
public class FullTimeWaiter  extends BaseWaiter{

    public FullTimeWaiter(String name) {
        super(name, 8);
    }

    @Override
    public void work() {
        setEfficiency(Math.max(getEfficiency() - 1, 0));
    }
}
