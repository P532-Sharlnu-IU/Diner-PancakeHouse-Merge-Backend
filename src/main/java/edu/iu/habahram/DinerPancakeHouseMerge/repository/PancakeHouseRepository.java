package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseIterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class PancakeHouseRepository {
    public List<MenuItem> getTheMenu() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
//        return pancakeHouseMenu.getMenuItems();
        Iterator iterator = pancakeHouseMenu.createIterator();
        List<MenuItem> menuItems = new ArrayList<>();
        while (iterator.hasNext()) {
            menuItems.add((MenuItem) iterator.next());
        }
        return menuItems;
    }

}
