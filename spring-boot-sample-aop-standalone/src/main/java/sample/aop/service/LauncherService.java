
package sample.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.aop.client.IRun;

@Component
public class LauncherService {
    @Autowired
    private IRun client;

    public void run(String... args) {
        this.client.run();
    }
}

