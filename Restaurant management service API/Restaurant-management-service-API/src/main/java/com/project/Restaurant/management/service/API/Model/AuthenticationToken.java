package com.project.Restaurant.management.service.API.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    User user;

    public AuthenticationToken(User user){
        this.user=user;
        this.tokenValue= UUID.randomUUID().toString();
        this.tokenCreationDateTime=LocalDateTime.now();
    }
}
