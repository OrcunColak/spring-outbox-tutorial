package com.colak.springoutboxtutorial.repository;

import com.colak.springoutboxtutorial.jpa.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<BookOrder, Integer> {
}
