package GameObjects;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class GameEngine {
   private final FieldConstructor fieldConstructor = new FieldConstructor();
   private final Cell[][]cells = fieldConstructor.initF();

   public void playGame(){
       FactoryThread factory = new FactoryThread();
       Arrays.stream(cells).forEach(c->Arrays.stream(c).forEach(q->q.getQueue().forEach(o->{
           Thread thread = factory.newThread(o);
           thread.start();
           ScheduledExecutorService service = Executors.newScheduledThreadPool(8, factory);
           service.shutdown();
       })));
   }

}
