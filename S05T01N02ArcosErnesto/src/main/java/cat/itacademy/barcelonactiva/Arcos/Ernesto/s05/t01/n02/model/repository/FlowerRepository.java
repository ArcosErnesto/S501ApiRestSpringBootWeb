package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer>{
}
