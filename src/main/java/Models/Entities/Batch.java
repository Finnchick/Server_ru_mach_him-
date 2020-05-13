package Models.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Seria")
public class Batch {
    private int Id;
    private Date Date;
    private Worker fWorker;
    private User fUser;
    private Set<Produce> Produces = new HashSet<Produce>(0);

    public Batch() {
    }

    public Batch(int id, java.sql.Date date, Worker worker, User user) {
        Id = id;
        Date = date;
        fWorker = worker;
        fUser = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Users_UserID")
    public User getfUser() {
        return fUser;
    }

    public void setfUser(User fUser) {
        this.fUser = fUser;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Workers_workerID")
    public Worker getfWorker() {
        return fWorker;
    }

    public void setfWorker(Worker fWorker) {
        this.fWorker = fWorker;
    }

    @Column(name = "date", length = 45)
    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SeriaID")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fBatch")
    public Set<Produce> getProduces() {
        return Produces;
    }

    public void setProduces(Set<Produce> Produces) {
        this.Produces = Produces;
    }
}
