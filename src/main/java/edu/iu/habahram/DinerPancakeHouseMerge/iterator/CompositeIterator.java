// src/main/java/edu/iu/habahram/DinerPancakeHouseMerge/iterator/CompositeIterator.java
package edu.iu.habahram.DinerPancakeHouseMerge.iterator;

import java.util.Iterator;
import java.util.Stack;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;

public class CompositeIterator implements Iterator<MenuComponent> {
    private Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        Iterator<MenuComponent> itr = stack.peek();
        if (!itr.hasNext()) {
            stack.pop();
            return hasNext();
        }
        return true;
    }

    @Override
    public MenuComponent next() {
        if (!hasNext()) {
            return null;
        }
        Iterator<MenuComponent> itr = stack.peek();
        MenuComponent component = itr.next();
        if (component instanceof Menu) {
            // push children iterator
            stack.push(((Menu) component).getIterator());
        }
        return component;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
