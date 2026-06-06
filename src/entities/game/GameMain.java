import entities.game.*;

void main() {

//    Guerriero g1 = new Guerriero("Biagio", 100, 10, 100, 100);
//    g1.mostraStatoCombattente();
//
//    Mago m1 = new Mago("Isabella", 100, 5, 70, 100);
//    m1.mostraStatoCombattente();
//
//    Mercante mer1 = new Mercante("Stefano", 50, 2, 300, 8);
//    mer1.mostraStato();


    Personaggio[] personaggi = new Personaggio[10];

    personaggi[0] = new Guerriero("Biagio", 100, 10, 90, 80);
    personaggi[1] = new Guerriero("Leonida", 90, 8, 85, 75);
    personaggi[2] = new Guerriero("Achille", 95, 9, 95, 70);
    personaggi[3] = new Mago("Merlino", 80, 10, 90, 100);
    personaggi[4] = new Mago("Gandalf", 75, 9, 95, 90);
    personaggi[5] = new Mago("Saruman", 70, 8, 85, 85);
    personaggi[6] = new Mago("Isabella", 65, 7, 80, 80);
    personaggi[7] = new Mercante("Stefano", 50, 2, 300, 8);
    personaggi[8] = new Mercante("Lorenzo", 45, 3, 500, 12);
    personaggi[9] = new Mercante("Marco", 40, 1, 150, 5);

    Combattimento.combatti(personaggi);


}
