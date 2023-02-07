package ma.fsdm.myapplication.entities;

public class Etudiant {
    private String nom;
    private String prenom;
    private String cne;
    private String motDePasse;
    private String email;

    public Etudiant(String nom, String prenom, String cne, String motDePasse, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.motDePasse = motDePasse;
        this.email = email;
    }

    public Etudiant() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
