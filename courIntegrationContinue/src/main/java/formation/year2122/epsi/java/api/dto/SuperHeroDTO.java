package formation.year2122.epsi.java.api.dto;

public class SuperHeroDTO {
    private long id;
    private String superHeroName;
    private String secretIdentity;

    public SuperHeroDTO() {
    }

    public SuperHeroDTO(long id, String superHeroName, String secretIdentity) {
        this.id = id;
        this.superHeroName = superHeroName;
        this.secretIdentity = secretIdentity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
