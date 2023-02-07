package ma.fsdm.myapplication.entities;

public class Coure {
    private String titre;
    private String filiere;
    private String matiere;
    private String uri;

    public Coure(String titre, String filiere, String matiere, String uri) {
        this.titre = titre;
        this.filiere = filiere;
        this.matiere = matiere;
        this.uri = uri;
    }

    public Coure() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
