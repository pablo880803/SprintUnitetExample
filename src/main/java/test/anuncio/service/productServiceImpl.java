package test.anuncio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.anuncio.dao.productRepository;
import test.anuncio.entity.product;

import java.util.List;

@Service
public class productServiceImpl implements productService{

    @Autowired
    productRepository productRepository;

    @Override
    public List<product> ListAllproduct() {
        return null;
    }

    @Override
    public product getproduct(Long area) {
        return null;
    }

    @Override
    public product Createproduct(product product) {
        return null;
    }

    @Override
    public product Updateproduct(product product) {
        return null;
    }

    @Override
    public product Deleteproduct(Long product) {
        return null;
    }
}
