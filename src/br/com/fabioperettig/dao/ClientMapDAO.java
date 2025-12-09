package br.com.fabioperettig.dao;

import br.com.fabioperettig.domain.Client;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientMapDAO implements IClientDAO{

    private Map<Long, Client> map;

    public ClientMapDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public boolean register(Client client) {
        if (this.map.containsKey(client.getId())){
            return false;
        }
        this.map.put(client.getId(), client);
        return true;
    }

    @Override
    public void remove(long id) {
        Client registeredClient = this.map.get(id);

        if (registeredClient != null){
            this.map.remove(registeredClient.getId(), registeredClient);
        }
    }

    @Override
    public void edit(Client client) {
        Client registeredClient = this.map.get(client.getId());

        if (registeredClient != null){
            registeredClient.setName(client.getName());
            registeredClient.setPhone(client.getPhone());
            registeredClient.setAddress(client.getAddress());
            registeredClient.setnAddress(client.getnAddress());
            registeredClient.setCity(client.getCity());
            registeredClient.setState(client.getState());

        }

    }

    @Override
    public Client check(long id) {
        return this.map.get(id);
    }

    @Override
    public Collection<Client> printAll() {
        return this.map.values();
    }
}
