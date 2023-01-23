package com.example.securitycustomauth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "login_unique_idx",
                                  columnNames = "login"),
                @UniqueConstraint(name = "email_unique_idx",
                                  columnNames = "email")})
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id",
                    foreignKey = @ForeignKey(name="user_fk_constraint"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id",
                    foreignKey = @ForeignKey(name="role_fk_constraint"))})
    private List<Role> roles;
}
