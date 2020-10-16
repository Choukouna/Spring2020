package sample.data.jpa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.model.Section;
import sample.data.jpa.model.Tablo;
import sample.data.jpa.service.SectionDao;
import sample.data.jpa.service.TabloDao;

@RestController
public class SectionServiceController {

    @Autowired
    private SectionDao sectionDao;

    @RequestMapping(value = "/sections")
    public ResponseEntity<Object> getSection() {
        return new ResponseEntity<Object>(sectionDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/section/{libSection}")
    public ResponseEntity<Object> getSectionByLibelle(@PathVariable("libSection") String lib) {
        return new ResponseEntity<Object>(sectionDao.findByLibelle(lib), HttpStatus.OK);
    }

    @RequestMapping(value = "/section/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createSection(@RequestBody Section s) {
        sectionDao.save(s);
        return new ResponseEntity<>("Section has been created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/section/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        sectionDao.deleteById(id);
        return new ResponseEntity<>("Section has been deleted successsfully", HttpStatus.OK);
    }
}
