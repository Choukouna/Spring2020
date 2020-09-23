package sample.aop.store;

public interface ILane extends IStore {
    public void addItemToCart(String prod);
    public void pay();
}