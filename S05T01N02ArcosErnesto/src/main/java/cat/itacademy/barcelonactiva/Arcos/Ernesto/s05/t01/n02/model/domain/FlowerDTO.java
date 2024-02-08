package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDTO {
    private int flowerId;
    private String flowerName;
    private String flowerCountry;
    private String flowerType;

    private static final List<String> EU_COUNTRIES = List.of("Austria", "Belgica", "Bulgaria", "Croacia", "Chipre", "Republica Checa",
            "Dinamarca", "Estonia", "Finlandia", "Francia", "Alemania", "Grecia", "Hungria", "Irlanda",
            "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Paises Bajos", "Polonia", "Portugal",
            "Rumania", "Eslovaquia", "Eslovenia", "España", "Suecia");

    public void determineTypeBranch() {
        if (EU_COUNTRIES.contains(flowerCountry)) {
            flowerType = "UE";
        } else {
            flowerType = "Fuera de UE";
        }
    }
}
