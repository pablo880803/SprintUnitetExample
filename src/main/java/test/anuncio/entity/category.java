package test.anuncio.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name="category")
public class category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idcategory;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(columnDefinition = "boolean default false")
    private Boolean hasLength;
}
