package com.gda.ws.repository;

import com.gda.ws.entity.History;
import com.gda.ws.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findHistoryByOrderUserId(Long id);

    Order findOrderByOrderId(Long id);

}
