package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.impl;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.Country;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.repository.CountryRepository;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> countryList() {
        return countryRepository.findAll();
    }
}
