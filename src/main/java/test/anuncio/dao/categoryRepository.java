package test.anuncio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.anuncio.entity.category;

public interface categoryRepository extends JpaRepository<category, Long> {
}
