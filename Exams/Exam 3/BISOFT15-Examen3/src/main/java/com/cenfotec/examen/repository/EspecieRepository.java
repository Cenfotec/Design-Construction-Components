package com.cenfotec.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examen.domain.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
	public Especie getByGuid(String guid);
}
