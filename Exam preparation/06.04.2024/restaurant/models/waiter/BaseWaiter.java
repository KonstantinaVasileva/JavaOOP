package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;
import restaurant.models.orders.TakenOrdersImpl;

import static restaurant.common.ExceptionMessages.WAITER_EFFICIENCY_LESS_THAN_ZERO;
import static restaurant.common.ExceptionMessages.WAITER_NAME_NULL_OR_EMPTY;

//TODO
public abstract class BaseWaiter implements Waiter {
    private String name;
    protected int efficiency;
    private TakenOrders takenOrders;

    protected BaseWaiter(String name, int efficiency) {
        setName(name);
        setEfficiency(efficiency);
        takenOrders = new TakenOrdersImpl();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEfficiency() {
        return efficiency;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new NullPointerException(WAITER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEfficiency(int efficiency) {
        if (efficiency < 0) {
            throw new IllegalArgumentException(WAITER_EFFICIENCY_LESS_THAN_ZERO);
        }
        this.efficiency = efficiency;
    }

    @Override
    public boolean canWork() {
        return getEfficiency() > 0;
    }

    @Override
    public TakenOrders takenOrders() {
        return takenOrders;
    }

    @Override
    public abstract void work();
}
