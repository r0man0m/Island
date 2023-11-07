package GameObjects;

import Interfaces.GameObject;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

public class Cell implements Serializable {
    int capacity = 100;
    int id;
    private ArrayBlockingQueue<GameObject> queue;

    public Cell() {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public ArrayBlockingQueue<GameObject> getQueue() {
        return queue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
