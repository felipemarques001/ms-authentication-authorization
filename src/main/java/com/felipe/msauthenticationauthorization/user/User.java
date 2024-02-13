package com.felipe.msauthenticationauthorization.user;

import com.felipe.msauthenticationauthorization.application.Application;
import com.felipe.msauthenticationauthorization.group.Group;
import com.felipe.msauthenticationauthorization.user.dtos.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToMany
    @JoinTable(
            name = "tb_user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;

    public User(UserRequestDTO dto, String password, Application application, List<Group> groups) {
        this.name = dto.name();
        this.username = dto.username();
        this.password = password;
        this.application = application;
        this.groups = groups;
    }
}
