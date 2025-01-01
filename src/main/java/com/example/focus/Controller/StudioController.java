package com.example.focus.Controller;

import com.example.focus.ApiResponse.ApiResponse;
import com.example.focus.DTO.SpaceDTO;
import com.example.focus.DTO.SpaceDTOIn;
import com.example.focus.Model.Space;
import com.example.focus.Model.Studio;
import com.example.focus.Service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/focus/studio")
public class StudioController {
    private final StudioService studioService;

    @GetMapping("/get-all-spaces")
    public ResponseEntity getAllSpaces(){
        List<SpaceDTO> spaces = studioService.getAllSpaces();
        return ResponseEntity.status(200).body(spaces);
    }

    @PostMapping("/add-space")
    public ResponseEntity addSpace(Space space, SpaceDTOIn spaceDTOIn){
        studioService.addSpace(space.getId(),spaceDTOIn);
        return ResponseEntity.status(200).body(space);
    }

    @PutMapping("/update-space")
    public ResponseEntity updateSpace(Space space, SpaceDTOIn spaceDTOIn){
        studioService.updateSpace(space.getId(),spaceDTOIn);
        return ResponseEntity.status(200).body(new ApiResponse("space updated successfully"));
    }

    @DeleteMapping("/delete-space/{space_name}")
    public ResponseEntity deleteSpace(Studio studio,@PathVariable String space_name){
        studioService.deleteSpace(studio.getId(),space_name);
        return ResponseEntity.status(200).body(new ApiResponse("space deleted successfully"));
    }

    @PutMapping("/accept-or-reject/{response}")
    public ResponseEntity requestResponse(Studio studio,Integer request_id,@PathVariable String response){
        studioService.acceptOrRejectRequest(studio.getId(),request_id,response);
        return ResponseEntity.status(200).body(new ApiResponse("your request is "+response+"ed"));
    }

}
