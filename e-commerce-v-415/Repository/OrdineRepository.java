package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Beans.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
	Ordine findByEmail(String email);
}