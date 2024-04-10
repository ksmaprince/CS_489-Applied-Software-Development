package edu.miu.cs489.ADSApp.repository;

import edu.miu.cs489.ADSApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
