package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCountry;

    @Column(name="iso")
    private String iso;

    @Column(name = "country_name")
    private String countryName;
}
