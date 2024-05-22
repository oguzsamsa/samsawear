package com.workintech.samsawear.repository;

import com.workintech.samsawear.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
