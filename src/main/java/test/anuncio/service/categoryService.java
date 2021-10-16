package test.anuncio.service;

import org.springframework.stereotype.Service;
import test.anuncio.entity.category;

import java.util.List;

public interface categoryService {
    public List<category> ListAllcategory();

    public category getcategory(Long area);

    public category Createcategory(category category);

    public category Updatecategory(category category);

    public category Deletecategory(Long category);
}
