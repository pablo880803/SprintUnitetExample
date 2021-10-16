package test.anuncio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.anuncio.entity.product;

public interface productRepository extends JpaRepository<product, Long> {
}
