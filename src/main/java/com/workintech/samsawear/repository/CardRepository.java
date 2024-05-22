package com.workintech.samsawear.repository;

import com.workintech.samsawear.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
