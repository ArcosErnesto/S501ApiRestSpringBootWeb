package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.BranchDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BranchService {
    BranchDTO add(BranchDTO branchDTO);
    Optional<BranchDTO> update(int id, BranchDTO branchDTO);
    String delete(int id);
    Optional<Branch> getOne(int id);
    List<BranchDTO> findAll();
}
