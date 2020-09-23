package sample.simple.bank;

import org.springframework.stereotype.Component;

@Component
public class Bank implements IBank {
    @Override
    public void transfer(String cpte1, String cpte2, int mount) {
        System.out.println("transfer done \n cpte 1 : " + cpte1 + " -> cpte2 : " + cpte2 + ", montant : " + mount);
    }
}