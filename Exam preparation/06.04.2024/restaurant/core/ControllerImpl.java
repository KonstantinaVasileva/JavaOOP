package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.Working;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.Repository;
import restaurant.repositories.WaiterRepository;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Client> clientRepository;
    private Repository<Waiter> waiterRepository;
    private int count;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter = switch (type) {
            case "FullTimeWaiter" -> new FullTimeWaiter(waiterName);
            case "HalfTimeWaiter" -> new HalfTimeWaiter(waiterName);
            default -> throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        };
        waiterRepository.add(waiter);
        return WAITER_ADDED.formatted(type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        clientRepository.add(client);
        return CLIENT_ADDED.formatted(clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.byName(waiterName);
        if (!waiterRepository.remove(waiter)) {
            throw new IllegalArgumentException(WAITER_DOES_NOT_EXIST.formatted(waiterName));
        }
        return WAITER_REMOVE.formatted(waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        if (!clientRepository.remove(clientRepository.byName(clientName))) {
            throw new IllegalArgumentException(CLIENT_DOES_NOT_EXIST.formatted(clientName));
        }
        return CLIENT_REMOVE.formatted(clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (waiterRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Working working = new WorkingImpl();
        working.takingOrders(clientRepository.byName(clientName), waiterRepository.getCollection());
        count++;
        return ORDERS_SERVING.formatted(clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder(count == 0 ?"None"
                : FINAL_CLIENTS_COUNT.formatted(count));
        output.append(System.lineSeparator());
        output.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());

        waiterRepository.getCollection()
                .forEach(w->{
                    output.append(FINAL_WAITER_NAME.formatted(w.getName())).append(System.lineSeparator());
                    output.append(FINAL_WAITER_EFFICIENCY.formatted(w.getEfficiency())).append(System.lineSeparator());
                    output.append(FINAL_WAITER_ORDERS
                            .formatted(String.join(FINAL_WAITER_ORDERS_DELIMITER, w.takenOrders().getOrdersList())))
                            .append(System.lineSeparator());
                });
        //Name: {waiterName}
        //Efficiency: {waiterEfficiency}
        //Taken orders: {order1, order2, order3, …, ordern}

        return output.toString();
    }
}
