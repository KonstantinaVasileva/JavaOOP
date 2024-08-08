package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Vehicle> vehicleRepository;
    private Repository<Worker> workerRepository;

    public ControllerImpl() {
        this.vehicleRepository = new VehicleRepository();
        this.workerRepository = new WorkerRepository();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker = switch (type) {
            case "FirstShift" -> new FirstShift(workerName);
            case "SecondShift" -> new SecondShift(workerName);
            default -> throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        };
        workerRepository.add(worker);
        return ADDED_WORKER.formatted(type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        vehicleRepository.add(new VehicleImpl(vehicleName, strengthRequired));
        return SUCCESSFULLY_ADDED_VEHICLE.formatted(vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Tool tool = new ToolImpl(power);
        Worker byName = workerRepository.findByName(workerName);
        if (byName == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        byName.addTool(tool);
        return SUCCESSFULLY_ADDED_TOOL_TO_WORKER.formatted(power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Vehicle vehicle = vehicleRepository.findByName(vehicleName);
        Worker worker = workerRepository.getWorkers().stream()
                .filter(w -> w.getStrength() > 70).findFirst()
                .orElse(null);
        if (worker == null) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        Shop shop = new ShopImpl();
        shop.make(vehicle, worker);
        long count = worker.getTools().stream()
                .filter(Tool::isUnfit).count();
        StringBuilder output = new StringBuilder();
        output.append(VEHICLE_DONE.formatted(vehicleName, vehicle.reached() ? "done" : "not done"));
        output.append(COUNT_BROKEN_INSTRUMENTS.formatted(count));
        return output.toString().trim();
    }

    @Override
    public String statistics() {
        long count = vehicleRepository.getWorkers().stream()
                .filter(Vehicle::reached)
                .count();
        StringBuilder output = new StringBuilder();
        output.append("%s vehicles are ready!".formatted(count)).append(System.lineSeparator());
        output.append("Info for workers:").append(System.lineSeparator());
        for (Worker worker : workerRepository.getWorkers()) {
            output.append("Name: %s, Strength: %s".formatted(worker.getName(), worker.getStrength()));
            output.append(System.lineSeparator());
            output.append("Tools: %s fit left"
                    .formatted(worker.getTools().size() - worker.getTools().stream().filter(Tool::isUnfit).count()));
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
