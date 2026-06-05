package interfaces.game;

import entities.game.Personaggio;

public interface Combattente {
    void azione(Personaggio avversario);

    void mostraStatoCombattente();

}
