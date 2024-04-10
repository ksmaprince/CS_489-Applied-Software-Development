package edu.miu.cs489.ADSApp.repository;

import edu.miu.cs489.ADSApp.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {
}
