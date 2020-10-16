package sample.data.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.model.User;
import sample.data.jpa.service.UserDao;

@RestController
public class UserServiceController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users")
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<Object>(userDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{search}")
    public ResponseEntity<Object> getCardByLielle(@PathVariable("search") String pseudo) {
        return new ResponseEntity<Object>(userDao.findByPseudo(pseudo), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        userDao.save(user);
        return new ResponseEntity<>("User has been created successfully", HttpStatus.CREATED);
    }
}
