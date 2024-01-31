package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.BranchDTO;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @PostMapping("/add")
    public ResponseEntity<BranchDTO> add(@RequestBody BranchDTO branchDTO) {
        BranchDTO newBranch = branchService.add(branchDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBranch);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<BranchDTO>> update(@PathVariable int id, @RequestBody BranchDTO branchDTO){
        Optional<BranchDTO>  updatedBranch= branchService.update(id, branchDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedBranch);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable int id) {
        String msg = branchService.delete(id);
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Branch> getOneBranch(@PathVariable int id) {
        Optional<Branch> branch = branchService.getOne(id);
        return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BranchDTO>> list() {
        List<BranchDTO> branches = branchService.findAll();
        return ResponseEntity.ok(branches);
    }
}
