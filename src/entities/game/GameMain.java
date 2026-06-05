import entities.game.Guerriero;
import entities.game.Mago;
import entities.game.Mercante;

void main() {

    Guerriero g1 = new Guerriero("Biagio", 100, 10, 100, 100);

    g1.mostraStatoCombattente();

    Mago m1 = new Mago("Isabella", 100, 5, 70, 100);

    m1.mostraStatoCombattente();

    Mercante mer1 = new Mercante("Stefano", 50, 2, 300, 8);

    mer1.mostraStato();
}
