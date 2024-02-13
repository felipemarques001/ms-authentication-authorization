package com.felipe.msauthenticationauthorization.group;

import com.felipe.msauthenticationauthorization.application.Application;
import com.felipe.msauthenticationauthorization.permission.Permission;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_GROUP")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToMany
    @JoinTable(
            name = "tb_group_permission",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;

    public Group(String name, Application application, ArrayList<Permission> permissions) {
        this.name = name;
        this.application = application;
        this.permissions = permissions;
    }
}
