package sample.aop.store;

public interface IFastLane extends IStore{
    public void oneShotOrder(String prod, int qte);
}