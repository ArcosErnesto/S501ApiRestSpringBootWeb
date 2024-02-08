package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.impl;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.exception.BranchNotFoundException;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.repository.BranchRepository;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public BranchDTO add(BranchDTO branchDTO) {
        Branch branch = convertToDomain(branchDTO);
        branch = branchRepository.save(branch);
        return convertToDTO(branch);
    }

    @Override
    public Optional<BranchDTO> update(int id, BranchDTO branchDTO) {
        Optional<Branch> branchOptional = branchRepository.findById(id);
        if (branchOptional.isPresent()) {
            Branch branchDb = branchOptional.get();

            branchDb.setBranchName(branchDTO.getBranchName());
            branchDb.setBranchCountry(branchDTO.getBranchCountry());

            branchRepository.save(branchDb);

            return Optional.of(convertToDTO(branchDb));
        }
        return Optional.empty();
    }

    @Override
    public BranchDTO findById(int id) {
        Optional<Branch> branchOptional = branchRepository.findById(id);
        Branch branch = branchOptional.get();
        return convertToDTO(branch);
    }

    @Override
    public String delete(int id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(()-> new BranchNotFoundException("Sucursal no encontrada con el id "+id));
        branchRepository.delete(branch);
        return "Sucursal eliminada con exito con el id: "+id;
    }

        @Override
        public Optional<Branch> getOne(int id) {
            Optional<Branch> branch = Optional.ofNullable(branchRepository.findById(id)
                    .orElseThrow(() -> new BranchNotFoundException("Sucursal no encontrada")));
            return branch;
        }

    @Override
    public List<BranchDTO> findAll() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Branch convertToDomain(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setBranchId(branchDTO.getBranchId());
        branch.setBranchName(branchDTO.getBranchName());
        branch.setBranchCountry(branchDTO.getBranchCountry());
        return branch;
    }

    private BranchDTO convertToDTO(Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setBranchId(branch.getBranchId());
        branchDTO.setBranchName(branch.getBranchName());
        branchDTO.setBranchCountry(branch.getBranchCountry());
        branchDTO.determineTypeBranch();
        return branchDTO;
    }
}
