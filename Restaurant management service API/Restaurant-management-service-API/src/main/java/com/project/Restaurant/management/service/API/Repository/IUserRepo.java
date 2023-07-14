package com.project.Restaurant.management.service.API.Repository;

import com.project.Restaurant.management.service.API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByGmail(String newEmail);
}
