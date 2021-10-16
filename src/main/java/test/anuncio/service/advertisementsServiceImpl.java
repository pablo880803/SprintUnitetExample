package test.anuncio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.anuncio.dao.advertisementsRepository;
import test.anuncio.entity.advertisements;

import java.util.List;

@Service
public class advertisementsServiceImpl implements advertisementsService{

    @Autowired
    advertisementsRepository advertisementsRepository;

    @Override
    public List<advertisements> ListAlladvertisements() {
        return advertisementsRepository.findAll();
    }

    @Override
    public advertisements getadvertisements(Long id) {
        return advertisementsRepository.findById(id).orElse(null);
    }

    @Override
    public advertisements Createadvertisements(advertisements advertisements) {
        return advertisementsRepository.saveAndFlush(advertisements);
    }

    @Override
    public advertisements Updateadvertisements(advertisements advertisements) {
        return advertisementsRepository.saveAndFlush(advertisements);
    }

    @Override
    public advertisements Deleteadvertisements(Long advertisements) {
        advertisements advertisements1 = advertisementsRepository.findById(advertisements).orElse(null);
        advertisementsRepository.delete(advertisements1);
        return advertisements1;
    }
}
