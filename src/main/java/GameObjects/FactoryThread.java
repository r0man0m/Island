package GameObjects;

import java.util.concurrent.ThreadFactory;

public class FactoryThread implements ThreadFactory {
    public FactoryThread() {
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        return thread;
    }
}
