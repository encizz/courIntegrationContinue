package formation.year2122.epsi.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "superhero")
public class SuperHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // long

    @Column(
            name = "superhero_name", // superhero-name
            nullable = false, //true
            length = 100 // 255
    )
    private String superHeroName;

    @Column(
            name = "secret_identity"
            // nullable = true,
            // length = 255
    )
    private String secretIdentity;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "superhero_power", // default => super_heroes_powers
            joinColumns = {@JoinColumn(name = "superhero_id")}, // default => super_heroes_id
            inverseJoinColumns = {@JoinColumn(name = "power_id")} // default => power_id
    )
    private List<Power> powers;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "superhero_vilain",
            joinColumns = {@JoinColumn(name = "superhero_id")},
            inverseJoinColumns = {@JoinColumn(name = "vilain_id")}
    )
    private List<Vilain> vilains;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "nemesis_id", referencedColumnName = "id")
    private Vilain nemesis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id") // default => mentor
    private SuperHero mentor;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.PERSIST)
    private List<SuperHero> sidekicks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public List<Vilain> getVilains() {
        return vilains;
    }

    public void setVilains(List<Vilain> vilains) {
        this.vilains = vilains;
    }

    public Vilain getNemesis() {
        return nemesis;
    }

    public void setNemesis(Vilain nemesis) {
        this.nemesis = nemesis;
    }

    public SuperHero getMentor() {
        return mentor;
    }

    public void setMentor(SuperHero mentor) {
        this.mentor = mentor;
    }

    public List<SuperHero> getSidekicks() {
        return sidekicks;
    }

    public void setSidekicks(List<SuperHero> sidekicks) {
        this.sidekicks = sidekicks;
    }
}
