package com.colak.springoutboxtutorial.repository;

import com.colak.springoutboxtutorial.jpa.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxEventRepository extends JpaRepository<OutboxEvent, Long> {
}
