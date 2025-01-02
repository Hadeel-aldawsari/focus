
package com.example.focus.Service;
import com.example.focus.ApiResponse.ApiException;
import com.example.focus.DTO.OUT.PhotographerDTOOUT;
import com.example.focus.Model.Photographer;
import com.example.focus.Model.Profile;
import com.example.focus.Repository.PhotographerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotographerService {
    private final PhotographerRepository photographerRepository;


    public List<PhotographerDTOOUT> getAllPhotographers() {
        List<Photographer> photographers = photographerRepository.findAll();
        List<PhotographerDTOOUT> photographerDTOOUTs = new ArrayList<>();

        for (Photographer photographer : photographers) {
            PhotographerDTOOUT photographerDTOOUT = new PhotographerDTOOUT(
                    photographer.getUsername(),
                    photographer.getName(),
                    photographer.getCity(),
                    photographer.getEmail(),
                    photographer.getPhoneNumber()
            );
            photographerDTOOUTs.add(photographerDTOOUT);
        }
        return photographerDTOOUTs;
    }


    public void PhotographerRegistration(Photographer photographer) {

        Profile emptyProfile = new Profile();
        emptyProfile.setDescription("");
        emptyProfile.setNumberOfPosts(0);
        emptyProfile.setImage("");

        photographer.setProfile(emptyProfile);

        photographerRepository.save(photographer);
    }


    public void updatePhotographer(Integer id, Photographer photographer) {
        Photographer existingPhotographer = photographerRepository.findPhotographersById(id);
        if (existingPhotographer != null) {
            existingPhotographer.setName(photographer.getName());
            existingPhotographer.setCity(photographer.getCity());
            existingPhotographer.setEmail(photographer.getEmail());
            existingPhotographer.setUsername(photographer.getUsername());
        }else {
            throw new ApiException("Photographer Not Found");
        }
            photographerRepository.save(existingPhotographer);

    }


    public void deletePhotographer(Integer id) {
        Photographer existingPhotographer = photographerRepository.findPhotographersById(id);
        if (existingPhotographer != null) {
            photographerRepository.delete(existingPhotographer);
        } else {
            throw new ApiException("Photographer Not Found");
        }
    }
}

