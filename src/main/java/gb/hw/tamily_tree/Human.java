package gb.hw.tamily_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Human<E extends FamilyTreeItem<E>> implements Serializable {

    private String name;


    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, LocalDate dateBirth, LocalDate dateDeath, Gender gender, Human mother, Human father) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.gender = gender;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();

    }


    public Human(String name, Gender gender, LocalDate dateBirth) {
        this(name, dateBirth, null, gender, null, null);
    }

    public Human(String name, Gender gender, LocalDate dateBirth, Human mother, Human father) {
        this(name, dateBirth, null, gender, mother, father);
    }

    public boolean addChildren(Human<E> child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Gender getGender(){
        return gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }
    public Human getFather(){
        for(Human parent: parents){
            if(parent.getGender()==Gender.male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for(Human parent: parents){
            if(parent.getGender()==Gender.female){
                return parent;
            }
        }
        return null;
    }


    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;


    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ");
        stringBuilder.append(name);
        stringBuilder.append(", gender: ");
        stringBuilder.append(getGender());
        stringBuilder.append(", age: ");
        stringBuilder.append(getAge());
        stringBuilder.append(", mother: ");
        stringBuilder.append(getMotherInfo());
        stringBuilder.append(", father: ");
        stringBuilder.append(getFatherInfo());
        stringBuilder.append(", children: ");
        stringBuilder.append(getChildrenInfo());
        return stringBuilder.toString();
    }

    public String getMotherInfo(){
        String res = "mother: ";
        Human mother = getMother();
        if(mother!=null){
            res+= mother.getName();
        }
        else {
            res+="unknown";
        }
        return res;

    }

    public String getFatherInfo(){
        String res = "father: ";
        Human father = getFather();
        if(father!=null){
            res+= father.getName();
        }
        else {
            res+="unknown";
        }
        return res;

    }


    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("chilren: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());

            }


        } else {
            res.append("none");
        }
        return res.toString();
    }

    public int getAge(){
        if(dateDeath==null){
            return  getPeriod(dateBirth, LocalDate.now());
        }else {
            return getPeriod(dateBirth,dateDeath);
        }
    }

    private int getPeriod(LocalDate dateBirth, LocalDate dateDeath){
        Period diff = Period.between(dateBirth,dateDeath);
        return diff.getYears();

    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setDateDeath(LocalDate dateDeath) {
        this.dateDeath = dateDeath;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }

}
