package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;
    private final CafeRepository cafeRepository;

    public MergeController(DinerRepository dinerRepository,
                            PancakeHouseRepository pancakeHouseRepository, CafeRepository cafeRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        this.cafeRepository = cafeRepository;
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {

        List<MenuItem> dinerMenu = Arrays.asList(dinerRepository.getTheMenu());
//        List<MenuItem> pancakeHouseMenu = pancakeHouseRepository.getTheMenu();

        PancakeHouseMenu menu = new PancakeHouseMenu();

//        List<MenuItem> mergedMenu = new ArrayList<>(dinerMenu);
//        mergedMenu.addAll(pancakeHouseMenu);
        List<MenuItem> mergedMenu = new ArrayList<>(dinerMenu);
        Iterator iterator = menu.createIterator();
        while (iterator.hasNext()) {
            mergedMenu.add((MenuItem) iterator.next());
        }

        Iterator<MenuItem> cIterator = cafeRepository.getTheMenuIterator();
        while (cIterator.hasNext()) {
            mergedMenu.add((MenuItem) cIterator.next());
        }

        mergedMenu.sort(Comparator.comparing(MenuItem::getName));

        return mergedMenu;
    }
}

