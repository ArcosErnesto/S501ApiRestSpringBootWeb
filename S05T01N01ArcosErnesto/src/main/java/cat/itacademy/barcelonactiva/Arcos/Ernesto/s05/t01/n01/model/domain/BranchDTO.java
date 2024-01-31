package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain;

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
    private String branchCountry;
    private String branchType;

    private static final List<String> EU_COUNTRIES = List.of("Austria", "Belgica", "Bulgaria", "Croacia", "Chipre", "Republica Checa",
            "Dinamarca", "Estonia", "Finlandia", "Francia", "Alemania", "Grecia", "Hungria", "Irlanda",
            "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Paises Bajos", "Polonia", "Portugal",
            "Rumania", "Eslovaquia", "Eslovenia", "España", "Suecia");

    public void determineTypeBranch() {
        if (EU_COUNTRIES.contains(branchCountry)) {
            branchType = "UE";
        } else {
            branchType = "Fuera de UE";
        }
    }
}
