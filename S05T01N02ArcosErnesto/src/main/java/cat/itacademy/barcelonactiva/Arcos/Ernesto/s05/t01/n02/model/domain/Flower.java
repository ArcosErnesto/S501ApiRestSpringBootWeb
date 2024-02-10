package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@Getter
@Setter

@Schema(description = "Flower Model Information")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Flower Id", example = "123")
    private int flowerId;

    @Column(nullable = false, length = 45)
    @Schema(description = "Flower name", example = "Margarita")
    private String flowerName;

    @Schema(description = "Flower country", example = "España")
    @Column(nullable = false, length = 45)
    private String flowerCountry;

    public Flower(String flowerName, String flowerCountry) {
        this.flowerName = flowerName;
        this.flowerCountry = flowerCountry;
    }
}
