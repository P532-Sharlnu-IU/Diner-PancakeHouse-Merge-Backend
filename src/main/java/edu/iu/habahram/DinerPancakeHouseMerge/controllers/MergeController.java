package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;

    public MergeController(DinerRepository dinerRepository,
                            PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {

        List<MenuItem> dinerMenu = Arrays.asList(dinerRepository.getTheMenu());
        List<MenuItem> pancakeHouseMenu = pancakeHouseRepository.getTheMenu();

        List<MenuItem> mergedMenu = new ArrayList<>(dinerMenu);
        mergedMenu.addAll(pancakeHouseMenu);

        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}

