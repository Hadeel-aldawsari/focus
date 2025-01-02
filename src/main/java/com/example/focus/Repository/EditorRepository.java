package com.example.focus.Repository;

import com.example.focus.Model.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorRepository extends JpaRepository<Editor,Integer> {

    Editor findEditorById(Integer id);

}
