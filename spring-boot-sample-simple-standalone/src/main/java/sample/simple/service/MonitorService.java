package sample.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.simple.client.IRun;

@Component
public class MonitorService {
    @Autowired
    private IRun client;

    public void run(String... args) {
        this.client.run();
    }
}
