package Abstract;

public abstract class Plant extends Living {
    public void grow(){

    }

    @Override
    public void play() {
        grow();
    }
}
