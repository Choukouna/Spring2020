package sample.aop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.aop.store.IFastLane;
import sample.aop.store.IJustHaveALook;
import sample.aop.store.ILane;
//import sample.simple.store.IStore;

@Component
public class Client implements IRun{
    @Autowired
    IFastLane fastLane;
    @Autowired
    ILane lane;
    @Autowired
    IJustHaveALook haveALook;

    @Override
    public void run() {
        System.out.println("run method from client");

        fastLane.oneShotOrder("Chocolat", 5);
        lane.addItemToCart("Oreo");
        lane.pay();
        haveALook.isAvailable("Ariel", 50);
        haveALook.getPrice("Card");
    }
}