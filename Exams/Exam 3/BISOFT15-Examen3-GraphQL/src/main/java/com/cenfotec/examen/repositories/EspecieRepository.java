package com.cenfotec.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.entities.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
	public Especie getByGuid(String guid);
}
