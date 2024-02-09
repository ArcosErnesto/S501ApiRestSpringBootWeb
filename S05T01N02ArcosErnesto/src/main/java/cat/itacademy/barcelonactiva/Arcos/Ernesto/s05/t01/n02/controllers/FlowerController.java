package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.FlowerDTO;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> add(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO newBranch = flowerService.add(flowerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBranch);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<FlowerDTO>> update(@PathVariable int id, @RequestBody FlowerDTO flowerDTO){
        Optional<FlowerDTO>  updatedBranch= flowerService.update(id, flowerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedBranch);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlower(@PathVariable int id) {
        String msg = flowerService.delete(id);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Flower> getOneBranch(@PathVariable int id) {
        Optional<Flower> flower = flowerService.getOne(id);
        return flower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> list() {
        List<FlowerDTO> flowers = flowerService.findAll();
        return ResponseEntity.ok(flowers);
    }
}
