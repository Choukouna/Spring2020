package sample.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import sample.simple.client.IRun;

public class MonitorService {
    @Autowired
    private IRun client;

    public void run(String... args) {
        this.client.run();
    }
}
