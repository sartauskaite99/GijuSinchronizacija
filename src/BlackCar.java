public class BlackCar extends Thread implements Car{
    private SyncAction action;
    private int id;

    public BlackCar(SyncAction action,int id){
        this.action = action;
        this.id = id;
    }
    public void run() {
        try {
            action.blackRoadCarStarts();
            drive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.blackRoadCarStops();
    }

    public void drive() throws InterruptedException {
        System.out.println(this.id + " black car STARTS driving");
        Thread.sleep(1000);
        System.out.println(this.id + " black car STOPS driving");
    }
}
