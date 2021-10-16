package test.anuncio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.anuncio.entity.advertisements;

public interface advertisementsRepository extends JpaRepository<advertisements, Long> {
}
