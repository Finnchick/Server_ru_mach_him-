package Models.Entities;

import Enums.Roles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "User")
public class User {
    private int Id;
    private String Login;
    private String Password;
    private Roles Role;
    private Set<Batch> Batches = new HashSet<>(0);
    public User(){

    }
    public User(int id, String login, String password, Roles role) {
        Id = id;
        Login = login;
        Password = password;
        Role = role;
    }
    @Column(length = 45)
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    @Column(length = 45)
    public Roles getRole() {
        return Role;
    }

    public void setRole(Roles role) {
        Role = role;
    }
    @Column(length = 45)
    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="UserID")
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "fUser")
    public Set<Batch> getBatches() {
        return Batches;
    }

    public void setBatches(Set<Batch> batches) {
        Batches = batches;
    }
}
