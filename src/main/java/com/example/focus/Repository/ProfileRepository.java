
package com.example.focus.Repository;

import com.example.focus.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    Profile findProfileById(Integer id);
}
