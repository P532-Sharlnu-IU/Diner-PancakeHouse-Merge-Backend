package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergeController {

    MergerRepository mergerRepository;

    public MergeController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        Iterator<Menu> menuIterator = mergerRepository.getTheMenus().iterator();
        while (menuIterator.hasNext()) {
            Menu menu = menuIterator.next();
            Iterator<MenuItem> iterator = menu.createIterator();
            while(iterator.hasNext()) {
                MenuItem menuItem = iterator.next();
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }
}

