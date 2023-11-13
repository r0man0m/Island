package GameObjects;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class GameEngine {
   private static final FieldConstructor fieldConstructor = new FieldConstructor();
   private static final Cell[][]cells = fieldConstructor.initF();

   public static void playGame(){
       FactoryThread factory = new FactoryThread();
       Arrays.stream(cells).forEach(c->Arrays.stream(c).forEach(q->q.getQueue().forEach(o->{
           Thread thread = factory.newThread(o);
           thread.start();
           ScheduledExecutorService service = Executors.newScheduledThreadPool(8, factory);
           service.shutdown();
       })));
   }

    public static Cell[][] getCells() {
        return cells;
    }
}
