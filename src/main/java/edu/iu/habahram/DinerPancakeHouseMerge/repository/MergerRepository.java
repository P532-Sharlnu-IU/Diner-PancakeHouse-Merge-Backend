package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import edu.iu.habahram.DinerPancakeHouseMerge.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.*;

@Repository
public class MergerRepository {


    public  List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getVegetarianMenuItems() {
        List<MenuItemRecord> records = new ArrayList<>();
        MenuComponent all = new Menu("ALL MENUS","All menus combined");
        all.add(new DinerMenu("DINER MENU","Lunch"));
        all.add(new PancakeHouseMenu("PANCAKE HOUSE MENU","Breakfast"));
        all.add(new CafeMenu("CAFE MENU","Dinner"));

        Iterator<MenuComponent> itr = new CompositeIterator(all.getIterator());
        while (itr.hasNext()) {
            MenuComponent comp = itr.next();
            if (comp instanceof MenuItem mi && mi.isVegetarian()) {
                records.add(new MenuItemRecord(
                        mi.getName(), mi.getDescription(), true, mi.getPrice()));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getBreakfastMenuItems() {
        return filterByMenu(new PancakeHouseMenu("PANCAKE HOUSE MENU","Breakfast"));
    }
    public List<MenuItemRecord> getLunchMenuItems() {
        return filterByMenu(new DinerMenu("DINER MENU","Lunch"));
    }
    public List<MenuItemRecord> getSupperMenuItems() {
        return filterByMenu(new CafeMenu("CAFE MENU","Dinner"));
    }

    private List<MenuItemRecord> filterByMenu(MenuComponent menu) {
        List<MenuItemRecord> recs = new ArrayList<>();
        Iterator<MenuComponent> itr = new CompositeIterator(menu.getIterator());
        while (itr.hasNext()) {
            MenuComponent comp = itr.next();
            if (comp instanceof MenuItem mi) {
                recs.add(new MenuItemRecord(
                        mi.getName(), mi.getDescription(), mi.isVegetarian(), mi.getPrice()));
            }
        }
        return recs;
    }


    public void saveCustomer(Customer cust) {
        File file = new File("data/customers.txt");
        file.getParentFile().mkdirs();
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file, true))) {
            w.write(cust.getUsername()
                    + "," + cust.getPassword()
                    + "," + cust.getEmail());
            w.newLine();
        } catch (IOException e) {
            throw new UncheckedIOException("Could not save customer", e);
        }
    }

}