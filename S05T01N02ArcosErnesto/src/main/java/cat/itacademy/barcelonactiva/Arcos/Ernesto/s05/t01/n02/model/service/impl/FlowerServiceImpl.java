package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.service.impl;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.FlowerDTO;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.exception.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.repository.FlowerRepository;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public FlowerDTO add(FlowerDTO flowerDTO) {
        Flower flower = convertToDomain(flowerDTO);
        flower = flowerRepository.save(flower);
        return convertToDTO(flower);
    }

    @Override
    public Optional<FlowerDTO> update(int id, FlowerDTO flowerDTO) {
        Optional<Flower> branchOptional = flowerRepository.findById(id);
        if (branchOptional.isPresent()) {
            Flower flowerDb = branchOptional.get();

            flowerDb.setFlowerName(flowerDTO.getFlowerName());
            flowerDb.setFlowerCountry(flowerDTO.getFlowerCountry());

            flowerRepository.save(flowerDb);

            return Optional.of(convertToDTO(flowerDb));
        }
        return Optional.empty();
    }

    @Override
    public String delete(int id) {
        Flower flower = flowerRepository.findById(id)
                .orElseThrow(()-> new FlowerNotFoundException("Flor no encontrada con el id "+id));
        flowerRepository.delete(flower);
        return "Flor eliminada con exito con el id: "+id;
    }

    @Override
    public Optional<Flower> getOne(int id) {
        Optional<Flower> flower = Optional.ofNullable(flowerRepository.findById(id)
                .orElseThrow(() -> new FlowerNotFoundException("Flor no encontrada")));
        return flower;
    }

    @Override
    public List<FlowerDTO> findAll() {
        List<Flower> flowers = flowerRepository.findAll();
        return flowers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Flower convertToDomain(FlowerDTO flowerDTO) {
        Flower flower = new Flower();
        flower.setFlowerId(flowerDTO.getFlowerId());
        flower.setFlowerName(flowerDTO.getFlowerName());
        flower.setFlowerCountry(flowerDTO.getFlowerCountry());
        return flower;
    }

    private FlowerDTO convertToDTO(Flower flower) {
        FlowerDTO flowerDTO = new FlowerDTO();
        flowerDTO.setFlowerId(flower.getFlowerId());
        flowerDTO.setFlowerName(flower.getFlowerName());
        flowerDTO.setFlowerCountry(flower.getFlowerCountry());
        flowerDTO.determineTypeBranch();
        return flowerDTO;
    }
}
