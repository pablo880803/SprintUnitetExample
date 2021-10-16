package test.anuncio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.anuncio.entity.category;
import test.anuncio.service.categoryServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/category")
public class categoryController {

    private static Logger LOG = LoggerFactory.getLogger(categoryController.class);

    @Autowired
    categoryServiceImpl categoryServiceImpl;

    @GetMapping()
    public ResponseEntity<Object> categoryList() {
        List<category> lista;
        lista = categoryServiceImpl.ListAllcategory();
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<category> categoryById(@PathVariable("id") Long id) {

        category category = categoryServiceImpl.getcategory(id);

        if (null == category) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(category);

    }

    @PostMapping
    public ResponseEntity<category> categoryAdd(@RequestBody category category) {

        category areaCreate = categoryServiceImpl.Createcategory(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(areaCreate);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<category> categoryUpdate(@PathVariable("id") Long id, @RequestBody category category) {

        category.setIdcategory(id);

        category categoryUpdate = categoryServiceImpl.Updatecategory(category);

        if (null == categoryUpdate) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoryUpdate);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<category> categoryDelete(@PathVariable("id") Long id) {

        category category = categoryServiceImpl.Deletecategory(id);

        if (null == category) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(category);

    }
    
}
