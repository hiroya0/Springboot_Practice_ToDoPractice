package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Memory;

public interface MemoryRepository extends JpaRepository<Memory,Long>{
	
}
