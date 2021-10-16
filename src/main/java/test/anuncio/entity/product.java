package test.anuncio.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name="product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idproduct;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    //@JsonFormat(pattern="HH:mm:ss")
    private Date releaseTime;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    //@JsonFormat(pattern="HH:mm:ss")
    private Date insertTime;

    @JsonIgnoreProperties
    @JoinColumn(name = "category", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private category category;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer view;

    @Column(nullable = false, length = 200)
    private String abbreviation;


}
