
//4. "Baltųjų - Raudonųjų" gijų veikos sinchronizatorius. -
//Vienu metu leidžiama būti "aktyvioms" tik vienos spalvos gijoms
//(klasikinės  "skaitytojų-rašytojų" problemos variacija).

    //Problema: juodo ir balto kelio masinu sankryza. Vienu metu gali vaziuoti tik vienos spalvos kelio juostos masinos.
    //Jei masinos vaziuotu vienu metu visos kartu, ivyktu susidurimas.

import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String args[]) throws InterruptedException{
        SyncAction syncAction = new SyncAction();
        int iteration = 0;
        while(iteration < 50) {
            WhiteCar whiteRoadCar = new WhiteCar(syncAction,iteration);
            BlackCar blackRoadCar = new BlackCar(syncAction,iteration);
            blackRoadCar.start();
            Thread.sleep(5000);
            whiteRoadCar.start();
            Thread.sleep(6000);
            iteration++;
        }
    }
}
