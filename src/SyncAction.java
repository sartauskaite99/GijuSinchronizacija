public class SyncAction {
    private int white = 0;
    private int black = 0;
    public synchronized void whiteRoadCarStarts() throws InterruptedException {
        while(black>0){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        white++;
        checkException();
    }
    public synchronized void whiteRoadCarStops(){
        white--;
        notifyAll();
    }
    public synchronized void blackRoadCarStarts() throws InterruptedException {
        while(white>0){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        black++;
        checkException();
    }
    public synchronized void blackRoadCarStops(){
        black--;
        notifyAll();
    }
    private void checkException() throws InterruptedException {
        if(white>0 && black>0){
            throw new InterruptedException();
        }
    }
}
