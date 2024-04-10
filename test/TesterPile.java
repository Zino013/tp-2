
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesterPile {

    @Test
    public void testAjouterGardien() {
        // Création du zoo
        Zoo zoo = new Zoo("Mon Zoo");

        Gardien drSmith1 = new Gardien("Dr. Smith", 15);
        Gardien drPatel1 = new Gardien("Dr. Patel", 20);
        Gardien drLyding1 = new Gardien("Dr. Lyding", 18);
        Gardien drGrandbois1 = new Gardien("Dr. Grandbois", 22);
        Gardien drSkelgaard1 = new Gardien("Dr. Skelgaard", 17);

        Veterinaire drSmith = new Veterinaire("Dr. Smith", Classe.Poisson);
        Veterinaire drPatel = new Veterinaire("Dr. Patel", Classe.Cetace);
        Veterinaire drGrandbois = new Veterinaire("Dr. Grandbois", Classe.Oiseau);
        Veterinaire drSkelgaard = new Veterinaire("Dr. Skelgaard", Classe.Mammifere);
        Veterinaire drLyding = new Veterinaire("Dr. Lyding", Classe.Reptile);

        // Création de quelques enclos
        Enclos enclos1 = new Enclos("Les Poissons", 3, drSmith, null);
        Enclos enclos2 = new Enclos("Les Cétacés", 3, drPatel, null);
        Enclos enclos3 = new Enclos("Les Reptiles", 3, drLyding, null);
        Enclos enclos4 = new Enclos("Les Oiseaux", 3, drGrandbois, null);
        Enclos enclos5 = new Enclos("Les Mammifères", 3, drSkelgaard, null);

        zoo.ajouterEnclos(new Enclos[]{enclos1, enclos2, enclos3, enclos4, enclos5});

        zoo.ajouterGardien(drSmith1 );
        zoo.ajouterGardien(drPatel1 );
        zoo.ajouterGardien(drLyding1 );
        zoo.ajouterGardien(drGrandbois1 );
        zoo.ajouterGardien(drSkelgaard1 );


        assertEquals(drSmith1, zoo.getPileGardiens().getGardiens()[0]);
        assertEquals(drPatel1, zoo.getPileGardiens().getGardiens()[1]);
        assertEquals(drLyding1, zoo.getPileGardiens().getGardiens()[2]);
        assertEquals(drGrandbois1, zoo.getPileGardiens().getGardiens()[3]);
        assertEquals(drSkelgaard1, zoo.getPileGardiens().getGardiens()[4]);

        assertEquals(drSmith1, enclos1.getGardien());
        assertEquals(drPatel1, enclos2.getGardien());
        assertEquals(drLyding1, enclos3.getGardien());
        assertEquals(drGrandbois1, enclos4.getGardien());
        assertEquals(drSkelgaard1, enclos5.getGardien());
    }
}