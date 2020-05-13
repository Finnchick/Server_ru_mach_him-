package Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Produce {
    private int Id;
    private String Name;
    private int Strength;
    private int Weight;
    private int Size;
    private int Thickness;
    private int Appearance;
    private Batch fBatch;
    private Standart fStandart;
    private Worker fWorker;

    public Produce(int id, int strength, int weight, int size, int thickness, int appearance, Batch batch, Standart standart, Worker worker,String name) {
        Id = id;
        Strength = strength;
        Weight = weight;
        Size = size;
        Thickness = thickness;
        Appearance = appearance;
        fBatch = batch;
        fStandart = standart;
        fWorker = worker;
        Name = name;
    }

    public Produce() {

    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Series_Workers_workerID")
    public Worker getfWorker() {
        return fWorker;
    }

    public void setfWorker(Worker fWorker) {
        this.fWorker = fWorker;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BaseProducts_BaseProductID")
    public Standart getfStandart() {
        return fStandart;
    }


    public void setfStandart(Standart fStandart) {
        this.fStandart = fStandart;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Series_SeriesID")
    public Batch getfBatch() {
        return fBatch;
    }

    public void setfBatch(Batch fBatch) {
        this.fBatch = fBatch;
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
    @Column(name = "ProductID")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    @Column(name = "pr_name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
