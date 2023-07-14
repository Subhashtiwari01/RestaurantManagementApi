package com.project.Restaurant.management.service.API.Repository;

import com.project.Restaurant.management.service.API.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {
}
