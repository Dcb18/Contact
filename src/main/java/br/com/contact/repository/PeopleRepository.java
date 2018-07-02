package br.com.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contact.model.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
	
	public List<People> findByName(String name);
}
