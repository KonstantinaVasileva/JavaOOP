package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop{
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        while (worker.canWork() && worker.getTools().iterator().hasNext() && !vehicle.reached()){
            Tool tool = worker.getTools().iterator().next();
            worker.working();
            tool.decreasesPower();
            vehicle.making();
        }

    }
}
