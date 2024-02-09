package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.service;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.FlowerDTO;

import java.util.List;
import java.util.Optional;

public interface FlowerService {
    FlowerDTO add(FlowerDTO flowerDTO);
    Optional<FlowerDTO> update(int id, FlowerDTO flowerDTO);
    String delete(int id);
    Optional<Flower> getOne(int id);
    List<FlowerDTO> findAll();
}
