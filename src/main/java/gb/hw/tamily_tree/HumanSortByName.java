package gb.hw.tamily_tree;

import java.util.Comparator;

public class HumanSortByName<E extends  FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
