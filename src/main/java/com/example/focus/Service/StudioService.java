package com.example.focus.Service;

import com.example.focus.ApiResponse.ApiException;
import com.example.focus.DTO.SpaceDTO;
import com.example.focus.DTO.SpaceDTOIn;
import com.example.focus.DTO.StudioDTO;
import com.example.focus.DTO.StudioDTOIn;
import com.example.focus.Model.Space;
import com.example.focus.Model.Studio;
import com.example.focus.Model.StudioRequest;
import com.example.focus.Repository.SpaceRepository;
import com.example.focus.Repository.StudioRepository;
import com.example.focus.Repository.StudioRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudioService {
    private final StudioRepository studioRepository;
    private final SpaceRepository spaceRepository;
    private final StudioRequestRepository studioRequestRepository;

    public List<StudioDTO> getAllStudios(){
        List<Studio> studios = studioRepository.findAll();
        List<StudioDTO> studioDTOS = new ArrayList<>();
        for (Studio studio : studios){
            StudioDTO studioDTO = new StudioDTO(studio.getName(),studio.getDescription(),studio.getLocation(),studio.getCommercialRecord());
            studioDTOS.add(studioDTO);
        }
        return studioDTOS;
    }

    public void registerStudio(StudioDTOIn studioDTOIn){
        Studio studio = studioRepository.findStudioByUsername(studioDTOIn.getUsername());
        if(studio != null){
            throw new ApiException("studio is exists");
        }
        Studio studio1 = new Studio();
        studio1.setName(studioDTOIn.getName());
        studio1.setDescription(studioDTOIn.getDescription());
        studio1.setLocation(studioDTOIn.getLocation());
        studio1.setCommercialRecord(studioDTOIn.getCommercialRecord());
        studio1.setUsername(studioDTOIn.getUsername());
        studio1.setPassword(studioDTOIn.getPassword());
        studio1.setIsActivated(false);
        studioRepository.save(studio1);

    }

    // get spaces
    public List<SpaceDTO> getAllSpaces(){
        List<Space> spaces = spaceRepository.findAll();
        List<SpaceDTO> spaceDTOS = new ArrayList<>();
        for (Space space : spaces){
            SpaceDTO spaceDTO = new SpaceDTO(space.getName(),space.getType(),space.getArea(),space.getDescription(),space.getPrice(),space.getStatus(),space.getImage());
            spaceDTOS.add(spaceDTO);
        }
        return spaceDTOS;
    }

    // studio add new space
    public void addSpace (Integer studio_id,SpaceDTOIn spaceDTOIn){
        Studio studio = studioRepository.findStudioById(studio_id);
        if(studio == null){
            throw new ApiException("studio not found");
        }
        if (!studio.getIsActivated()){
            throw new ApiException("studio is not activated");
        }
        Space space = spaceRepository.findSpaceByName(spaceDTOIn.getName());
        if(space != null){
            throw new ApiException("space already exists");
        }
        Space newSpace = new Space();
        newSpace.setName(spaceDTOIn.getName());
        newSpace.setType(spaceDTOIn.getType());
        newSpace.setArea(spaceDTOIn.getArea());
        newSpace.setDescription(spaceDTOIn.getDescription());
        newSpace.setPrice(spaceDTOIn.getPrice());
        newSpace.setStatus(spaceDTOIn.getStatus());
        newSpace.setImage(spaceDTOIn.getImage());
        spaceRepository.save(newSpace);

    }

    // studio delete space
    public void deleteSpace (Integer studio_id,String space_name){
        Studio studio = studioRepository.findStudioById(studio_id);
        if(studio == null){
            throw new ApiException("studio not found");
        }
        if (!studio.getIsActivated()){
            throw new ApiException("studio is not activated");
        }
        Space space = spaceRepository.findSpaceByName(space_name);
        if(space == null){
            throw new ApiException("space not found");
        }
        spaceRepository.delete(space);

    }

    // update space
    public void updateSpace (Integer studio_id,SpaceDTOIn spaceDTOIn){
        Studio studio = studioRepository.findStudioById(studio_id);
        if(studio == null){
            throw new ApiException("studio not found");
        }
        if (!studio.getIsActivated()){
            throw new ApiException("studio is not activated");
        }
        Space space = spaceRepository.findSpaceByName(spaceDTOIn.getName());
        if(space == null){
            throw new ApiException("space not found");
        }
        space.setName(spaceDTOIn.getName());
        space.setType(spaceDTOIn.getType());
        space.setArea(spaceDTOIn.getArea());
        space.setDescription(spaceDTOIn.getDescription());
        space.setPrice(spaceDTOIn.getPrice());
        space.setStatus(spaceDTOIn.getStatus());
        space.setImage(spaceDTOIn.getImage());
        spaceRepository.save(space);

    }

    // studio can accept or reject the request from photographer
    public void acceptOrRejectRequest(Integer studio_id,Integer request_id,String response){
        Studio studio = studioRepository.findStudioById(studio_id);
        if(studio == null){
            throw new ApiException("studio not found");
        }
        if(!studio.getIsActivated()){
            throw new ApiException("studio is not activated");
        }
        StudioRequest sr = studioRequestRepository.findStudioRequestById(request_id);
        if(sr == null){
            throw new ApiException("request not found");
        }
        if (response.equalsIgnoreCase("accepted")){
            sr.setStatus(response);
        }else if (response.equalsIgnoreCase("rejected")){
            sr.setStatus(response);
        }

    }


}
