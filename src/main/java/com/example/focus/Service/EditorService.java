package com.example.focus.Service;


import com.example.focus.DTO.EditorDTOOUT;
import com.example.focus.Model.Editor;
import com.example.focus.Repository.EditorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorService {
    private final EditorRepository editorRepository;

    public List<EditorDTOOUT> getAllEditors() {
        List<Editor> editors = editorRepository.findAll();
        List<EditorDTOOUT> editorDTOOUTS = new ArrayList<>();

        for (Editor editor : editors) {
            EditorDTOOUT editorDTOOUT = new EditorDTOOUT(
                    editor.getName(),
                    editor.getCity(),
                    editor.getPhoneNumber(),
                    editor.getEmail(),
                    editor.getUsername(),
                    editor.getPassword()
            );
            editorDTOOUTS.add(editorDTOOUT);
        }
        return editorDTOOUTS;
    }


    public void addEditor(Editor editor) {
        editorRepository.save(editor);
    }

    public void updateEditor(Integer id, Editor editor) {
        Editor existingEditor = editorRepository.findEditorById(id);
        if (existingEditor != null) {
            existingEditor.setName(editor.getName());
            existingEditor.setCity(editor.getCity());
            existingEditor.setPhoneNumber(editor.getPhoneNumber());
            existingEditor.setEmail(editor.getEmail());
            existingEditor.setUsername(editor.getUsername());
            existingEditor.setPassword(editor.getPassword());
            editorRepository.save(existingEditor);
        } else {
            throw new RuntimeException("Editor not found");
        }
    }

    public void deleteEditor(Integer id) {
        Editor existingEditor = editorRepository.findEditorById(id);
        if (existingEditor != null) {
            editorRepository.delete(existingEditor);
        } else {
            throw new RuntimeException("Editor not found");
        }
    }
}