package formation.year2122.epsi.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "power")
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false
    )
    private String name;
    private String description;

    @ManyToMany(mappedBy = "powers")
    private List<SuperHero> superHeroes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SuperHero> getSuperHeroes() {
        return superHeroes;
    }

    public void setSuperHeroes(List<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
