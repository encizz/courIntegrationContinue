package formation.year2122.epsi.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vilain")
public class Vilain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        name = "name",
        nullable = false,
        length = 100
    )
    private String name;

    @Column(
        name = "secret_identity"
    )
    private String secretIdentity;

    @ManyToMany(mappedBy = "vilains")
    private List<SuperHero> superHeroes;

    @OneToOne(mappedBy = "nemesis")
    private SuperHero nemesis;

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

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public List<SuperHero> getSuperHeroes() {
        return superHeroes;
    }

    public void setSuperHeroes(List<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

    public SuperHero getNemesis() {
        return nemesis;
    }

    public void setNemesis(SuperHero nemesis) {
        this.nemesis = nemesis;
    }
}
