package com.example.focus.Controller;


import com.example.focus.ApiResponse.ApiResponse;
import com.example.focus.DTO.ToolDTOOUT;
import com.example.focus.Model.Tool;
import com.example.focus.Service.ToolServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/focus/tool")
@RequiredArgsConstructor
public class ToolController {
    private final ToolServices toolServices;

    @GetMapping("/get-all")
    public ResponseEntity getAllTools() {
        return ResponseEntity.status(200).body(toolServices.getAllTools());
    }

    @PostMapping("/add-tool/{photographerid}")
    public ResponseEntity addTool(@RequestBody @Valid Tool tool, @PathVariable Integer photographerid) {
        toolServices.addTool(tool, photographerid);
        return ResponseEntity.status(200).body(new ApiResponse("Tool added successfully"));
    }

    @PutMapping("/update-tool/{id}")
    public ResponseEntity<ApiResponse> updateTool(@PathVariable Integer id, @RequestBody @Valid Tool tool) {
        toolServices.updateTool(id, tool);
        return ResponseEntity.status(200).body(new ApiResponse("Tool updated successfully"));
    }

    @DeleteMapping("/delete-tool/{id}")
    public ResponseEntity<ApiResponse> deleteTool(@PathVariable Integer id) {
        toolServices.deleteTool(id);
        return ResponseEntity.status(200).body(new ApiResponse("Tool deleted successfully"));
    }
}
