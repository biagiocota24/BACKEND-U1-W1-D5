import entities.mediaPlayer.*;

void main() {
    //RECORDING
    Recording r1 = new Recording("Gigi", 50, "mp3");
    r1.setVolume(9); //OK
    r1.AlzaVolume();//OK
    r1.abbassaVolume();//OK
//    r1.play();//OK
//    System.out.println(r1);

    //VIDEO
    Video v1 = new Video("La vita degli squali", 360, "mp4");
    v1.aumentaLuminosita();//OK
    v1.riduciLuminsita();//OK
    v1.AlzaVolume();//OK
    v1.abbassaVolume();//OK
    v1.setVolume(12); //OK
//    v1.play(); //OK
//    System.out.println(v1);

    //IMAGE
    Image img1 = new Image("IO", "jpg");
    img1.aumentaLuminosita();//OK
    img1.riduciLuminsita();//OK
//    img1.show();   //OK
//    System.out.println(img1);

    // QUI BISOGNA PRIMA CREARE 5 ELEMENTI MULTIMEDIALI CON VALORI DA TASTIERA E POI PARTE
//    MediaPlayer.riproduci();

    Video v2 = new Video("La vita degli squali", 360, "mp4");
    Video v3 = new Video("La vita degli squali", 360, "mp4");

    Media[] playlist = {r1, v1, img1, v2, v3};

    // QUESTO PARTE CON UN ARRAY PRONTO
    MediaPlayer.riproduciConListaPronta(playlist);


}
