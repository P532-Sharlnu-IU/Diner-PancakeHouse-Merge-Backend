package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    MergerRepository mergerRepository;

    public MergeController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarian() {
        return mergerRepository.getVegetarianMenuItems();
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfast() {
        return mergerRepository.getBreakfastMenuItems();
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunch() {
        return mergerRepository.getLunchMenuItems();
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupper() {
        return mergerRepository.getSupperMenuItems();
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Customer customer) {
        mergerRepository.saveCustomer(customer);
        return ResponseEntity.ok("Signup successful");
    }

}