// src/main/java/edu/iu/habahram/DinerPancakeHouseMerge/iterator/NullIterator.java
package edu.iu.habahram.DinerPancakeHouseMerge.iterator;

import java.util.Iterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;

public class NullIterator implements Iterator<MenuComponent> {
    @Override public boolean hasNext() { return false; }
    @Override public MenuComponent next() { return null; }
    @Override public void remove() { throw new UnsupportedOperationException(); }
}

