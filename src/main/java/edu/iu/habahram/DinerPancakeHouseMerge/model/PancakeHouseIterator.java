package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


//-->NOT IN USE

public class PancakeHouseIterator implements Iterator<MenuItem> {
    List<MenuItem> items;
    int position = 0;

    public PancakeHouseIterator(List<MenuItem> items) {
        this.items = items;
    }

    public MenuItem next() {
        MenuItem menuItem = items.get(position);
        position = position + 1;
        return menuItem;
    }

    public boolean hasNext() {
        if (position >= items.size() || items.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }
}
