package com.gda.ws.repository;

import com.gda.ws.entity.History;
import com.gda.ws.entity.Order;
import com.gda.ws.entity.OrderStatus;
import com.gda.ws.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    User findUserByOrderUserId(Long id);

    OrderStatus findOrderStatusByOrderOrderStatusId(Long id);

    Order findOrderByOrderId(Long id);

}
