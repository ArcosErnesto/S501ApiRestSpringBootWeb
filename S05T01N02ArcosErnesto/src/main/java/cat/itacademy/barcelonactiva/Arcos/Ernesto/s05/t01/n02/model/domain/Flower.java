package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flowerId;
    @Column(nullable = false, length = 45)
    private String flowerName;
    @Column(nullable = false, length = 45)
    private String flowerCountry;
}
