package Models.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Worker")
public class Worker {
    private int Id;
    private String FIO;
    private String Position;
    private String Department;
    private Set<Produce> Produces = new HashSet<Produce>(0);
    private Set<Batch> Batches = new HashSet<Batch>(0);
    public Worker() {

    }

    public Worker(int id, String fio, String position, String department, Set<Produce> produces) {
        Id = id;
        FIO = fio;
        Position = position;
        Department = department;
        Produces = produces;
    }

    @Column(name = "otdel", length = 45)
    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fWorker")
    public Set<Produce> getProduces() {
        return Produces;
    }

    public void setProduces(Set<Produce> produces) {
        Produces = produces;
    }

    @Column(name = "position", length = 45)

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    @Column(name = "fio", length = 45)

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WorkerID", length = 45)

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fWorker")
    public Set<Batch> getBatches() {
        return Batches;
    }

    public void setBatches(Set<Batch> batches) {
        Batches = batches;
    }
}
