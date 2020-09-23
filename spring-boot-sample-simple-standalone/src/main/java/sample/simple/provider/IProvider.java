package sample.simple.provider;

public interface IProvider {
    public float getPrice();
    //Commander un certain produit p en une quantité q
    public void order(String prod, int qte);
}
