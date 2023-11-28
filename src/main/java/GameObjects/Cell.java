package GameObjects;

import Interfaces.GameObject;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

public class Cell implements Serializable {
    private  int capacity;
    private long id;
    private  ArrayBlockingQueue<GameObject> queue;

    public Cell() {
        setCapacity(1000);
        setId(id);
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public Cell(long id) {
        this.id = id;
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public ArrayBlockingQueue<GameObject> getQueue() {
        return queue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setQueue(ArrayBlockingQueue<GameObject> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Cell " + id;
    }
}
