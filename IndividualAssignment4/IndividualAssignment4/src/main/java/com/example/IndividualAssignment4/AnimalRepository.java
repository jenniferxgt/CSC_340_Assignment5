package com.example.IndividualAssignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findBySpecies(String species);

    @Query(value = "select * from animal", nativeQuery = true)
    List<Animal> findAllAnimals();

    @Query(value = "select * from animal a WHERE a.habitat = ?1", nativeQuery = true)
    List<Animal> findAnimalsByHabitat(String habitat);
}

