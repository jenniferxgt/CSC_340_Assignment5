package com.example.IndividualAssignment4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    //public List<Animal> getAllAnimals(){
    public String getAllAnimals(Model model){
        model.addAttribute("animalList", animalService.getAllAnimals());
        model.addAttribute("title", "All students");
        //return animalService.getAllAnimals();
        return "animal-list";
    }
    @GetMapping("/{animalId}")
    public String getAnimalById(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        //return animalService.getAnimalById(animalId);
        return "animal-details";
    }
    //*@PostMapping("/new")
    //public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal){
      //  animalService.addNewAnimal(animal);
        //return ResponseEntity.ok(animal);
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }
    //@PutMapping("/{animalId}")
    //public ResponseEntity<Animal> updateAnimal(@PathVariable int animalId, @RequestBody Animal animal){
      //  animalService.updateAnimal(animalId,animal);
        //return ResponseEntity.ok(animalService.getAnimalById(animalId));
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "animal-update";
    }
    //@DeleteMapping("/delete/{animalId}")
    //public List<Animal> deleteAnimalById(@PathVariable int animalId){
      //  animalService.deleteAnimalById(animalId);
        //return animalService.getAllAnimals();
    @PostMapping("/create")
    public String createAnimal(@ModelAttribute Animal animal){
        animalService.addNewAnimal((animal));
        return "redirect:animals/all";
    }
    @PostMapping("/update")
    public String updateAnimal(@ModelAttribute Animal animal){
        animalService.updateAnimal(animal.getAnimalId(), animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId){
        animalService.deleteAnimalById(animalId);
        return "redirect:animals/all";
    }
}
