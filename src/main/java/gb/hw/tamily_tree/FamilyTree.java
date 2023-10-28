package gb.hw.tamily_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {

    private List<E> humanList;

   public FamilyTree(List<E> humanList){
       this.humanList = humanList;
 }

 public FamilyTree(){
       this(new ArrayList<>());
 }

 public boolean add(E human){
       if (human == null){
           return false;
       }
       if(!humanList.contains(human)){
           humanList.add(human);

           addToParents(human);
           addToChildren(human);

           return true;
       }
       return false;
 }

 private void addToParents(E human){
       for(E parent:human.getParents()){
           parent.addChildren(human);
       }

 }


 private void addToChildren(E human){
       for(E child:human.getChildren()){
           child.addParent(human);
       }

 }

 public E getByName(String name){
       for(E human: humanList){
           if(human.getName().equals(name)){
               return human;
           }
       }
       return null;
 }

public String getInfo(){
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append(humanList.size());
       for (E human: humanList){
           stringBuilder.append(human.getInfo());
           stringBuilder.append("\n");
       }
       return stringBuilder.toString();
}

public Iterator<E> iterator(){
       return new HumanIterator(humanList);
}

public void sortByName(){
       humanList.sort(new HumanSortByName());
}

public void sortByAge(){
       humanList.sort(new HumanSortByAge());
}

}
