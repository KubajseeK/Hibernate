package sk.itsovy.kutka.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oven")
public class Oven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size")
    private int size;

    @Column(name = "material")
    private String material;

    @OneToMany(mappedBy = "oven", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Cake> cakes;

    public Oven() {
    }

    public Oven(int size, String material) {
        this.size = size;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public void add(Cake cake) {
        if (cakes == null) {
            cakes = new ArrayList<>();
        }
        cakes.add(cake);
        cake.setOven(this);
    }

    @Override
    public String toString() {
        return "Oven{" +
                "id=" + id +
                ", size=" + size +
                ", material='" + material + '\'' +
                '}';
    }
}
