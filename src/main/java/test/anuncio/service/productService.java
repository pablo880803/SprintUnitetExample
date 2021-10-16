package test.anuncio.service;

import test.anuncio.entity.product;

import java.util.List;

public interface productService {

    public List<product> ListAllproduct();

    public product getproduct(Long area);

    public product Createproduct(product product);

    public product Updateproduct(product product);

    public product Deleteproduct(Long product);
}
