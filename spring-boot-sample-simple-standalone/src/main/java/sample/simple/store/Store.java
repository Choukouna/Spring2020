package sample.simple.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.bank.IBank;
import sample.simple.provider.IProvider;

@Component
public class Store implements IFastLane, IJustHaveALook, ILane{
    //This bean is to use an instance of IBank and IProvider
    @Autowired
    IBank bank;
    @Autowired
    IProvider provider;

    //commander un produit en une quantite puis regler directement
    @Override
    public void oneShotOrder(String prod, int qte) {
        provider.order(prod, qte);
        bank.transfer("00004321", "2456", 100);
        System.out.println("One shot order called\n produit acheté : " + prod + ", quantite : " + qte);
    }

    //Retourne le prix du produit p
    @Override
    public float getPrice(String prod) {
        System.out.println("Get price called\n produit : " + prod + ", prix : 10$");
        return 5;
    }

    //Verifie la présence ou non en quantite qte du produit p
    @Override
    public boolean isAvailable(String prod, int qte) {
        System.out.println("isAvailable called\n produit : " + prod + " en quantite " + qte + " disponible");
        return true;
    }

    //ajout d'un produit au panier
    @Override
    public void addItemToCart(String prod) {
        System.out.println("Add item called\nproduit ajouté au panier : " + prod);
    }

    //paiement d'un panier
    @Override
    public void pay() {
        System.out.println("pay called\n montant du panier : 50$");
    }
}
