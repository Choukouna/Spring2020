package sample.data.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.model.Card;
import sample.data.jpa.service.CardDao;

import java.util.Optional;

@RestController
public class CardServiceController {
    @Autowired
    private CardDao cardDao;

    @RequestMapping(value = "/cards")
    public ResponseEntity<Object> getCard() {
        return new ResponseEntity<Object>(cardDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/card/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createCard(@RequestBody Card c) {
        cardDao.save(c);
        return new ResponseEntity<>("Card has been created successfully", HttpStatus.CREATED);
    }
    //get a card through it's label (using method findByLibelle of DAO which is generate by spring jpa)
    @RequestMapping(value = "/card/{libCard}")
    public ResponseEntity<Object> getCardByLielle(@PathVariable("libCard") String lib) {
        return new ResponseEntity<Object>(cardDao.findByLibelle(lib), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/card/{idCard}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("idCard") Long idCard) {
        cardDao.deleteById(idCard);
        return new ResponseEntity<>("Card has been deleted successsfully", HttpStatus.OK);
    }
}
