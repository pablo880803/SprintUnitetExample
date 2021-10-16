package test.anuncio.service;

import test.anuncio.entity.advertisements;

import java.util.List;

public interface advertisementsService {
    public List<advertisements> ListAlladvertisements();

    public advertisements getadvertisements(Long area);

    public advertisements Createadvertisements(advertisements advertisements);

    public advertisements Updateadvertisements(advertisements advertisements);

    public advertisements Deleteadvertisements(Long advertisements);
}
