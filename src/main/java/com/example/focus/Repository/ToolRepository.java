package com.example.focus.Repository;

import com.example.focus.Model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool,Integer> {

    Tool findToolById(Integer id);

    List<Tool> findToolByPhotographer(Integer photographerId);
}
