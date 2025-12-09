package br.com.fabioperettig.dao;

import br.com.fabioperettig.domain.Client;

import java.util.Collection;

public interface IClientDAO {

    public boolean register(Client client);
    public void remove(long id);
    public void edit(Client client);
    public Client check(long id);
    public Collection<Client> printAll();

}
