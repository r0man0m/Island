package Abstract;

public abstract class Plant extends Entity{
    public void grow(){

    }
    @Override
    public void play() {
        grow();
    }
}
