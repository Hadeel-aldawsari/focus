package com.example.focus.Service;

import com.example.focus.ApiResponse.ApiException;
import com.example.focus.DTO.ToolDTOOUT;
import com.example.focus.Model.Photographer;
import com.example.focus.Model.Tool;
import com.example.focus.Repository.PhotographerRepository;
import com.example.focus.Repository.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolServices {
    private final ToolRepository toolRepository;
    private final PhotographerRepository photographerRepository;

    public List<ToolDTOOUT> getAllTools() {
        List<Tool> tools = toolRepository.findAll();
        List<ToolDTOOUT> toolDTOOUTS = new ArrayList<>();
        for (Tool tool : tools) {
            ToolDTOOUT toolDTOOUT = new ToolDTOOUT(
                    tool.getName(),
                    tool.getDescription(),
                    tool.getCategory(),
                    tool.getBrand(),
                    tool.getCondition(),
                    tool.getRentalPrice(),
                    tool.getImageUrl(),
                    tool.getPhotographer().getId()

            );
            toolDTOOUTS.add(toolDTOOUT);
        }
        return toolDTOOUTS;
    }


    public void addTool(Tool tool, Integer photographerId) {
        Photographer photographer = photographerRepository.findPhotographersById(photographerId);
        if (photographer != null) {
            tool.setPhotographer(photographer);
            toolRepository.save(tool);
        } else {
            throw new ApiException("Photographer not found");
        }
    }


    public void updateTool(Integer id, Tool tool) {
        Tool existingTool = toolRepository.findToolById(id);
        if (existingTool != null) {
            existingTool.setName(tool.getName());
            existingTool.setDescription(tool.getDescription());
            existingTool.setCategory(tool.getCategory());
            existingTool.setBrand(tool.getBrand());
            existingTool.setCondition(tool.getCondition());
            existingTool.setRentalPrice(tool.getRentalPrice());
            existingTool.setImageUrl(tool.getImageUrl());
            toolRepository.save(existingTool);
        } else {
            throw new ApiException("Tool not found");
        }
    }


    public void deleteTool(Integer id) {
        Tool existingTool = toolRepository.findToolById(id);
        if (existingTool != null) {
            toolRepository.delete(existingTool);
        } else {
            throw new ApiException("Tool not found");
        }
    }


}