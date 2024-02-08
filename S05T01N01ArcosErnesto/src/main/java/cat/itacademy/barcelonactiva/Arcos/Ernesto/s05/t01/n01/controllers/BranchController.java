package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.Country;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.BranchService;
import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/views")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/add")
    public String add(Model model) {
        BranchDTO branchDTO = new BranchDTO();
        List<Country> countries = countryService.countryList();

        model.addAttribute("title", "Añadir sucursal:");
        model.addAttribute("branch", branchDTO);
        model.addAttribute("countries", countries);

        return "/views/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BranchDTO branchDTO){
        branchService.add(branchDTO);
        System.out.println("Sucursal guardada con exito.");
        return "redirect:/views/getAll";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int branchId, Model model) {
        BranchDTO updatedBranch = branchService.findById(branchId);
        List<Country> countries = countryService.countryList();

        model.addAttribute("title", "Modificar sucursal:");
        model.addAttribute("branch", updatedBranch);
        model.addAttribute("countries", countries);

        return "/views/add";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int branchId) {
        branchService.delete(branchId);
        System.out.println("Sucursal eliminada con exito.");
        return "redirect:/views/getAll";
    }

    @GetMapping("/getOne/{id}")
    public String getOne(@PathVariable("id") int branchId, Model model) {

        BranchDTO updatedBranch = branchService.findById(branchId);
        List<BranchDTO> branches = new ArrayList<>();
        branches.add(updatedBranch);
        model.addAttribute("title","Lista de sucursales:");
        model.addAttribute("branches",branches);

        return "views/getAll";
    }

    @GetMapping("/getAll")
    public String list(Model model) {
        List<BranchDTO> branches = branchService.findAll();
        model.addAttribute("title","Lista de sucursales:");
        model.addAttribute("branches",branches);
        return "views/getAll";
    }
}
