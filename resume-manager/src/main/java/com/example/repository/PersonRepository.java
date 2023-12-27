package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	@Query(value = "select p.id, p.name, r.id, r.company_name, r.resume_doc from resume_manager.person p inner join resume_manager.resume r on p.id=r.person_id", nativeQuery = true)
	List<Object[]> getPersonDetails(Long personId);

}
