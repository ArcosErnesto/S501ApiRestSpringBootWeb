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

    private static final List<String> EU_COUNTRIES = List.of(
            "Austria", "Bélgica", "Bulgaria", "Croacia", "Chipre", "República Checa",
            "Dinamarca", "Estonia", "Finlandia", "Francia", "Alemania", "Grecia", "Hungría", "Irlanda",
            "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Polonia", "Portugal",
            "Rumanía", "Eslovaquia", "Eslovenia", "España", "Suecia"
    );

    public void determineTypeBranch() {
        if (EU_COUNTRIES.contains(flowerCountry)) {
            flowerType = "UE";
        } else {
            flowerType = "Fuera de UE";
        }
    }
}
