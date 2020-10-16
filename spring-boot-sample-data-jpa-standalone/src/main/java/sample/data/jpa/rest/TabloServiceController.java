package sample.data.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.model.Tablo;
import sample.data.jpa.service.TabloDao;
import sample.data.jpa.service.UserDao;

@RestController
public class TabloServiceController {

    @Autowired
    private TabloDao tabloDao;

    @RequestMapping(value = "/tableaux")
    public ResponseEntity<Object> getTablo() {
        return new ResponseEntity<Object>(tabloDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/tableau/{title}")
    public ResponseEntity<Object> getTabloByTitle(@PathVariable("title") String title) {
        return new ResponseEntity<Object>(tabloDao.findByTitreProjet(title), HttpStatus.OK);
    }

    @RequestMapping(value = "/create/tableau", method = RequestMethod.POST)
    public ResponseEntity<Object> createTablo(@RequestBody Tablo tab) {
        tabloDao.save(tab);
        return new ResponseEntity<>("Kanban table has been created successfully", HttpStatus.CREATED);
    }
}
