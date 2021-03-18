package com.lambdaschool.getorders.repositories;

import com.lambdaschool.getorders.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//The CRUD Repository connecting Order to rest of the application
public interface OrdersRepository extends CrudRepository<Order, Long> {

    List<Order> findAllByAdvanceamountGreaterThan(Double amount);
}
