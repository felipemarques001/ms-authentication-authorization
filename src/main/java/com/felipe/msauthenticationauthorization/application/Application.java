package com.felipe.msauthenticationauthorization.application;

import com.felipe.msauthenticationauthorization.application.dtos.ApplicationRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, name = "access_key")
    private String accessKey;

    public Application(ApplicationRequestDTO dto) {
        this.name = dto.name();
        this.accessKey = dto.accessKey();
    }
}
