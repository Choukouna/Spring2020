package sample.simple.store;

public interface IJustHaveALook extends IStore{
    /**
     *
     * @return total price of a command
     */
    public float getPrice(String prod);
    public boolean isAvailable(String prod, int qte);
}