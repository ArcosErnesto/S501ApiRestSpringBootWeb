package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;
    @Column(nullable = false, length = 45)
    private String branchName;
    @Column(nullable = false, length = 45)
    private String branchCountry;
}
