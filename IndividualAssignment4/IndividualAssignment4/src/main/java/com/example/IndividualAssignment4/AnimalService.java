package com.example.IndividualAssignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals(){
        return animalRepository.findAllAnimals();
    }
    public Animal getAnimalById(int animalId){
        return animalRepository.findById(animalId).orElse(null);
    }
    public void addNewAnimal(Animal animal){
        animalRepository.save(animal);
    }
    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalById(animalId);
        if(existing != null) {
            existing.setName(animal.getName());
            existing.setScientificName(animal.getScientificName());
            existing.setSpecies(animal.getSpecies());
            existing.setHabitat(animal.getHabitat());
            existing.setDescription(animal.getDescription());
            animalRepository.save(existing);
        }
    }
    public void deleteAnimalById(int animalId){
        animalRepository.deleteById(animalId);
    }
}
