package GameObjects;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class GameEngine {
   private  final Cell[][]cells;

    public GameEngine(Cell[][]cells) throws IOException, InterruptedException {
        this.cells = cells;
    }

    public void playGame(){
       FactoryThread factory = new FactoryThread();
       Arrays.stream(cells).forEach(c->Arrays.stream(c).forEach(q->q.getQueue().forEach(o->{
           Thread thread = factory.newThread(o);
           thread.start();
           ScheduledExecutorService service = Executors.newScheduledThreadPool(8, factory);
           service.shutdown();
       })));
   }

    public  Cell[][] getCells() {
        return cells;
    }
}
