package GameObjects;

import Interfaces.GameObject;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

public class Cell implements Serializable {
    private  int capacity;
    private int id;
    private  ArrayBlockingQueue<GameObject> queue;

    public Cell() {
        setCapacity(100);
        setId(id);
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public Cell(int id) {
        this.id = id;
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
