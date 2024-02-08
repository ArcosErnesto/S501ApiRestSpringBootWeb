package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain.Country;
import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
    private int branchId;
    private String branchName;
    private Country branchCountry;
    private String branchType;

    private static final List<String> EU_COUNTRIES = List.of(
            "Austria", "Bélgica", "Bulgaria", "Croacia", "Chipre", "República Checa",
            "Dinamarca", "Estonia", "Finlandia", "Francia", "Alemania", "Grecia", "Hungría", "Irlanda",
            "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia", "Portugal",
            "Rumanía", "Eslovaquia", "Eslovenia", "España", "Suecia"
    );


    public void determineTypeBranch() {
        if (EU_COUNTRIES.contains(branchCountry.getCountryName())) {
            branchType = "UE";
        } else {
            branchType = "Fuera de UE";
        }
    }
}
