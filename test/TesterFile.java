import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TesterFile {
    private Zoo zoo;

    @BeforeEach
    public void creationzooo() {
        zoo = new Zoo("Parc Safari");
    }

    @Test
    public void testArriveeVisiteur() {

        String[] especesVisiteur1 = {"lion", "saumon", "marsouin"};
        String[] especesVisiteur2 = {"zèbre", "lion"};
        String[] especesVisiteur3 = {"saumon", "dauphin"};

        Visiteur visiteur1 = new Visiteur("Alice", 25, especesVisiteur1);
        Visiteur visiteur2 = new Visiteur("Bob", 70, especesVisiteur2);
        Visiteur visiteur3 = new Visiteur("Charlie", 30, especesVisiteur3);


        zoo.arriveeVisiteur(visiteur1);
        zoo.arriveeVisiteur(visiteur2);
        zoo.arriveeVisiteur(visiteur3);


        assertEquals(visiteur2, zoo.getFileVisiteurs().getPremier().getValeur());
        assertEquals(visiteur1, zoo.getFileVisiteurs().getPremier().getSuivant().getValeur());

    }
}