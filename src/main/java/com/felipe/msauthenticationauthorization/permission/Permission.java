package com.felipe.msauthenticationauthorization.permission;

import com.felipe.msauthenticationauthorization.permission.dtos.PermissionRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PERMISSION")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active;

    public Permission(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }
}
