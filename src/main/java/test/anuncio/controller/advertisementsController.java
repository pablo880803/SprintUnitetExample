package test.anuncio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.anuncio.entity.advertisements;
import test.anuncio.service.advertisementsServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/advertisements")
public class advertisementsController {

    private static Logger LOG = LoggerFactory.getLogger(advertisementsController.class);

    @Autowired
    advertisementsServiceImpl advertisementsServiceImpl;


    @GetMapping()
    public ResponseEntity<Object> advertisementsList() {
        List<advertisements> lista;
        lista = advertisementsServiceImpl.ListAlladvertisements();
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<advertisements> advertisementsById(@PathVariable("id") Long id) {

        advertisements advertisements = advertisementsServiceImpl.getadvertisements(id);

        if (null == advertisements) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(advertisements);

    }

    @PostMapping
    public ResponseEntity<advertisements> advertisementsAdd(@RequestBody advertisements advertisements) {

        advertisements areaCreate = advertisementsServiceImpl.Createadvertisements(advertisements);

        return ResponseEntity.status(HttpStatus.CREATED).body(areaCreate);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<advertisements> advertisementsUpdate(@PathVariable("id") Long id, @RequestBody advertisements advertisements) {

        advertisements.setIdadvertisements(id);

        advertisements advertisementsUpdate = advertisementsServiceImpl.Updateadvertisements(advertisements);

        if (null == advertisementsUpdate) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(advertisementsUpdate);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<advertisements> advertisementsDelete(@PathVariable("id") Long id) {

        advertisements advertisements = advertisementsServiceImpl.Deleteadvertisements(id);

        if (null == advertisements) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(advertisements);

    }
    
}
