package restaurant.models.waiter;

//TODO
public class HalfTimeWaiter  extends BaseWaiter{

    public HalfTimeWaiter(String name) {
        super(name, 4);
    }

    @Override
    public void work() {
        setEfficiency(Math.max(getEfficiency() - 2, 0));
    }
}
