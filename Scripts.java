
package exo1;


/**
 *
 * @author DELL
 */
public class Scripts {
    private int nmbscripts;
    private String developpeur;
    private String jour;
public Scripts(){    
}

public Scripts(int nmbscripts, String developpeur, String jour) {
    this.nmbscripts = nmbscripts;
    this.developpeur = developpeur;
    this.jour = jour;
    }

    public int getNmbscripts() {
        return nmbscripts;
    }

    public String getDeveloppeur() {
        return developpeur;
    }

    public String getJour() {
        return jour;
    }

    public void setNmbscripts(int nmbscripts) {
        this.nmbscripts = nmbscripts;
    }

    public void setDeveloppeur(String developpeur) {
        this.developpeur = developpeur;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }
}

