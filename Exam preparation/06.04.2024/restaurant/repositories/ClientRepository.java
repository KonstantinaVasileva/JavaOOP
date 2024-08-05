package restaurant.repositories;

import restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;

public class ClientRepository implements Repository <Client>{

    Collection<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return clients.stream().toList();
    }

    @Override
    public void add(Client client) {
        clients.add(client);
    }

    @Override
    public boolean remove(Client client) {
        return clients.remove(client);
    }

    @Override
    public Client byName(String name) {
        return clients.stream()
                .filter(c->c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
