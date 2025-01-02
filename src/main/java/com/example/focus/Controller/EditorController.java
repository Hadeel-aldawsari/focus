package com.example.focus.Controller;


import com.example.focus.DTO.EditorDTOOUT;
import com.example.focus.Model.Editor;
import com.example.focus.Service.EditorServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/focus/editor")
@RequiredArgsConstructor
public class EditorController {
    private final EditorServices editorServices;

    @GetMapping("/get-all")
    public ResponseEntity getAllEditors() {
        List<EditorDTOOUT> editorDTOOUTS = editorServices.getAllEditors();
        return ResponseEntity.ok(editorDTOOUTS);
    }

    @PostMapping("/add-editor")
    public ResponseEntity addEditor(@RequestBody @Valid Editor editor) {
        editorServices.addEditor(editor);
        return ResponseEntity.ok("Editor added successfully");
    }

    @PutMapping("/update-editor/{id}")
    public ResponseEntity updateEditor(@PathVariable Integer id, @RequestBody @Valid Editor editor) {
        editorServices.updateEditor(id, editor);
        return ResponseEntity.ok("Editor updated successfully");
    }

    @DeleteMapping("/delete-editor/{id}")
    public ResponseEntity<String> deleteEditor(@PathVariable Integer id) {
        editorServices.deleteEditor(id);
        return ResponseEntity.ok("Editor deleted successfully");
    }
}