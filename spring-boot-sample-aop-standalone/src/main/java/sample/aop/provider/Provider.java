package sample.aop.provider;

import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider{
    @Override
    public float getPrice() {
        System.out.println("getPrice called");
        return 10;
    }

    @Override
    public void order(String prod, int qte) {
        System.out.println("order called\n produit : " + prod + " commandé en quantité : " + qte);
    }
}
