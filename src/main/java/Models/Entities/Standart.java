package Models.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BaseProduct")
public class Standart {
    private int Id;
    private String Name;
    private int Strength;
    private int Weight;
    private int Size;
    private int Thickness;
    private int Appearance;
    private Set<Produce> Produces = new HashSet<Produce>(0);

    public Standart(int id, int strength, int weight, int size, int thickness, int appearance, String name) {
        Id = id;
        Strength = strength;
        Weight = weight;
        Size = size;
        Thickness = thickness;
        Appearance = appearance;
        Name = name;
    }

    public Standart() {

    }

    @Column(name = "appearance")
    public int getAppearance() {
        return Appearance;
    }

    public void setAppearance(int appearance) {
        Appearance = appearance;
    }

    @Column(name = "thickness")
    public int getThickness() {
        return Thickness;
    }

    public void setThickness(int thickness) {
        Thickness = thickness;
    }

    @Column(name = "size")
    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    @Column(name = "weight")
    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    @Column(name = "strength")
    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BaseProduct_ID")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fStandart")
    public Set<Produce> getProduces() {
        return Produces;
    }

    public void setProduces(Set<Produce> Produces) {
        this.Produces = Produces;
    }

    @Column(name = "pr_name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

