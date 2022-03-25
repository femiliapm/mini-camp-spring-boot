package id.latihan.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.latihan.spring.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
