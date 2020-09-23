package sample.aop.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank {
    @Override
    public void transfer(String cpte1, String cpte2, int mount) {
        //Nous allons ajouter un aspect pour la sécurité qui permettra de vérifier que le montant
        //du transfert est > 0
        System.out.println("transfer done \n cpte 1 : " + cpte1 + " -> cpte2 : " + cpte2 + ", montant : " + mount);
    }
}