public class Zoo {
    private String nom;
    private Pile pileGardiens;
    private File fileVisiteurs;
    private int nombreEnclos;
    private Enclos[] lesEnclos;
    private int nombreTotalAnimaux;

    public Zoo(String nom) {
        this.nom = nom;
        this.pileGardiens = new Pile();
        this.fileVisiteurs = new File();
    }

    public boolean ajouterEnclos(Enclos[] lesEnclos) {
        if (lesEnclos.length > pileGardiens.getNbElements()){
            pileGardiens.aggrandissement(pileGardiens.getGardiens());
        }
        nombreEnclos = lesEnclos.length;
        int point = 0;
        for (int i = 0; i < lesEnclos.length; i++) {
            pileGardiens.getGardiens()[i] = lesEnclos[i].getGardien();
            if (pileGardiens.getGardiens()[i] != null) {
                point += pileGardiens.getGardiens()[i].getCompetence();
                pileGardiens.setNbElements(pileGardiens.getNbElements());
            }
        }
        this.lesEnclos = lesEnclos;
        if (point < 20) {
            return false;
        }
        calculerNombreTotalAnimaux();
        return true;
    }

    public Visiteur retirerVisiteur() {
        Noeud nouveau = fileVisiteurs.getPremier();
        Visiteur enleverVisiteur = nouveau.getValeur();
        fileVisiteurs.setPremier(nouveau.getSuivant());
        fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() - 1);
        return enleverVisiteur;
    }

    public void arriveeVisiteur(Visiteur visiteur) {

        Noeud nouveauNoeud = new Noeud(visiteur);
        Noeud courant = fileVisiteurs.getPremier();
        if (fileVisiteurs.getNbElements() == 0) {
            fileVisiteurs.setPremier(nouveauNoeud);
            fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
            return;
        }

      if(visiteur.getAge() >= 65) {
          if (courant.getValeur().getAge() < 65) {
              Noeud ancienPremier = fileVisiteurs.getPremier();
              nouveauNoeud.setSuivant(ancienPremier);
              fileVisiteurs.setPremier(nouveauNoeud);
              fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
              return;
          } else {
              while (courant.getValeur().getAge() > 65) {
                  courant = courant.getSuivant();
              }

              Noeud noeudAuMilieu = courant.getSuivant();
              courant.setSuivant(nouveauNoeud);
              nouveauNoeud.setSuivant(noeudAuMilieu);
              fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
              return;
          }
      }
        while (courant.getSuivant() != null) {
            courant = courant.getSuivant();
        }
        courant.setSuivant(nouveauNoeud);
        fileVisiteurs.setNbElements(fileVisiteurs.getNbElements() + 1);
    }

    public void ajouterGardien(Gardien gardien) {
        pileGardiens.setGardiensajout(gardien);
        int nbEnclosSansGArdien = 0;
        int moinAnimaux = 999;
        for (int i = 0; i < lesEnclos.length; i++) {
            if (lesEnclos[i].getGardien() == null) {
                nbEnclosSansGArdien++;

                if (lesEnclos[i].getNombreAnimaux() < moinAnimaux) {
                    moinAnimaux = lesEnclos[i].getNombreAnimaux();
                }
            }
        }

        if (nbEnclosSansGArdien > 0) {
            for ( int i = 0; i < lesEnclos.length; i++) {
                if (lesEnclos[i].getGardien() == null){
                    if (lesEnclos[i].getNombreAnimaux() == moinAnimaux) {
                        System.out.println("On ajoute " + gardien.getNom() +  "à l'enclos " + lesEnclos[i].getNom());
                        lesEnclos[i].setGardien(gardien);
                        break;
                    }
            }
            }
        }
    }

    public Gardien retirerGardien() {
        int index = pileGardiens.getNbElements() - 1;
        int compteur = 0;
        String nom = "";

        // Trouver le nom du dernier gardien non-null
        for (int i = pileGardiens.getGardiens().length - 1; i >= 0; i--) {
            if (pileGardiens.getGardiens()[i] != null) {
                nom = pileGardiens.getGardiens()[i].getNom();
                break; // Sortir de la boucle une fois que le nom est trouvé
            }
        }

        // Calculer le compteur en excluant le dernier gardien ajouté
        for (int i = 0; i < pileGardiens.getGardiens().length - 1; i++) {
            if (pileGardiens.getGardiens()[i] != null && !pileGardiens.getGardiens()[i].getNom().equals(nom)) {
                compteur += pileGardiens.getGardiens()[i].getCompetence();
            }
        }

        if (compteur < 20){
            System.out.println("On ne peut enlever le gardien " + nom + " parce que les points d'expérience < 20");
            return  null;
        }else {
            Gardien[] nouveau = new Gardien[pileGardiens.getGardiens().length];
            for (int i = 0; i < pileGardiens.getGardiens().length - 1; i++) {
                if( pileGardiens.getGardiens()[i] != pileGardiens.getGardiens()[index] ){
                    nouveau[i] = pileGardiens.getGardiens()[i];
                }
            }
            Gardien gardienRetire = pileGardiens.getGardiens()[index];
            for (int i = 0; i < lesEnclos.length; i++) {
                if (lesEnclos[i].getGardien() == gardienRetire){
                    break;
                }
            }
            pileGardiens.setGardiensretire(nouveau);
            if(gardienRetire != null) {
                System.out.println("On retire le dernier gardien arrivé au zoo: " + gardienRetire.toString());
                retirerGardienEnclos(gardienRetire);
            }
            return gardienRetire;
        }
     }
        public void retirerGardienEnclos(Gardien gardien){
            for (int i = 0; i < lesEnclos.length; i++) {
                if (lesEnclos[i].getGardien() == gardien){
                    lesEnclos[i].setGardien(null);
                }
            }
        }
    public void calculerNombreTotalAnimaux() {
        int totalAnimaux = 0;
        for (int i = 0; i < lesEnclos.length; i++) {
            totalAnimaux += lesEnclos[i].getNombreAnimaux();
        }
        this.nombreTotalAnimaux = totalAnimaux;
    }
    public int getNombreTotalAnimaux() {
        return this.nombreTotalAnimaux;
    }


    public String toString(){
        String resultat = "Voici la pile des gardiens: \n" +pileGardiens.toString() + "\n";
        resultat += "Et la file des visiteurs: \n" + fileVisiteurs.toString() + "\n";
        resultat += "Le zoo est peuplé avec " + nombreTotalAnimaux + " animaux. Il y'a " + nombreEnclos + " enclos. \n";

        for (int i = 0; i < lesEnclos.length; i++) {
            resultat += lesEnclos[i].toString();
        }
        return resultat;
    }

    public Pile getPileGardiens() {
        return pileGardiens;
    }

    public File getFileVisiteurs() {
        return this.fileVisiteurs;
    }

    public Enclos[] getLesEnclos() {
        return lesEnclos;
    }

    public String getNom() {
        return nom;
    }

    public int getNombreEnclos() {
        return nombreEnclos;
    }
}
