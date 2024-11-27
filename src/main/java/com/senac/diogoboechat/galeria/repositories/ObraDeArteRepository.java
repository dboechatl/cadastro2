package com.senac.diogoboechat.galeria.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.diogoboechat.galeria.entities.ObraDeArte;

public interface ObraDeArteRepository extends JpaRepository<ObraDeArte, Integer> {
	List<ObraDeArte> findByStatus(int status);

}