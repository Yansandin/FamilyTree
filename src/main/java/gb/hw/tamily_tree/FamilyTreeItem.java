package gb.hw.tamily_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    void setId(long id);
    long getId();
    T getFather();
    T getMother();
    boolean addChildren(T human);
    boolean addParent(T human);
    String getName();
    String getInfo();
    LocalDate getDateBirth();
    LocalDate getDateDeath();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T human);
}
