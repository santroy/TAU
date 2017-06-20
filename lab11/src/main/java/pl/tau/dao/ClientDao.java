package pl.tau.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.tau.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client, Long> {
    @Override
    public Client get(Long key) {
        Client client = super.get(key);
        client.getOrders().size();
        return client;
    }
}