package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "branches")
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private int branchId;

    @Column(name = "branch_name")
    private String branchName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country branchCountry;

    public Branch(int branchId, String branchName, Country branchCountry) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchCountry = branchCountry;
    }

    public Branch(int branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Branch() {
    }
}
