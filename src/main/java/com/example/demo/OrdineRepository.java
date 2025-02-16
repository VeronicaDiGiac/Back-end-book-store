package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
	
	Ordine findByEmail(String email);
	Optional<Ordine> findById(Long id);
	List<Ordine> findByIdOIn(List<Long> idOProd);
	
}