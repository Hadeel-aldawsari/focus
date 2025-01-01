package com.example.focus.Repository;

import com.example.focus.Model.Studio;
import com.example.focus.Model.StudioRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRequestRepository extends JpaRepository<StudioRequest, Integer> {
    StudioRequest findStudioRequestById(Integer studioId);
}
