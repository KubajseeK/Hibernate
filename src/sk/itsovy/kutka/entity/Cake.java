package sk.itsovy.kutka.entity;

import javax.persistence.*;

@Entity
@Table(name = "cake")
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "oven_id")
    private Oven oven;

    public Cake() {
    }

    public Cake(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Oven getOven() {
        return oven;
    }

    public void setOven(Oven oven) {
        this.oven = oven;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", oven=" + oven +
                '}';
    }
}
