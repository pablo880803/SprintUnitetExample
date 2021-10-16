package test.anuncio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.anuncio.dao.categoryRepository;
import test.anuncio.entity.category;

import java.util.List;

@Service
public class categoryServiceImpl implements categoryService{

    @Autowired
    categoryRepository categoryRepository;

    @Override
    public List<category> ListAllcategory() {
        return categoryRepository.findAll();
    }

    @Override
    public category getcategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public category Createcategory(category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public category Updatecategory(category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public category Deletecategory(Long category) {
        category byId = categoryRepository.findById(category).orElse(null);;
        categoryRepository.delete(byId);
        return byId;
    }
}
