public class WhiteCar extends Thread implements Car{
    private SyncAction action;
    private int id;
    public WhiteCar(SyncAction action,int id){
        this.action = action;
        this.id = id;
    }
    public void run() {
        try {
            action.whiteRoadCarStarts();
            drive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.whiteRoadCarStops();
    }

    public void drive() throws InterruptedException {
        System.out.println(this.id + " white car STARTS driving");
        Thread.sleep(1000);
        System.out.println(this.id + " white car STOPS driving");
    }
}
