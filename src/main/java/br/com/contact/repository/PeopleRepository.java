package br.com.contact.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.contact.model.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
	
	@Query("SELECT people FROM People people LEFT JOIN fetch people.peopleContact contact "
			+ " where people.name = :name ")
	public List<People> findByName(@Param("name") String name);
	
	@Query("SELECT people FROM People people LEFT JOIN fetch people.peopleContact contact "
			+ " where people.id = :id ")
	public Optional<People> findById(@Param("id") Long id);
}
