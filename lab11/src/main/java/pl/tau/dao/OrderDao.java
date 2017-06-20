package pl.tau.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.tau.model.Order;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
}