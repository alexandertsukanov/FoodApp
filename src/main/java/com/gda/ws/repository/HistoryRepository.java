package com.gda.ws.repository;

import com.gda.ws.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

//    User findUserByOrderUserId(Long id);
//
//    OrderStatus findOrderStatusByOrderStatusId(Long id);
//
//    Order findOrderByOrderId(Long id);

}
