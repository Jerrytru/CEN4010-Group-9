package com.example.userProfiles.userProfile;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository     //This interface is responsible for DATA ACCESS
public interface ProfileRepository extends JpaRepository<Profile, Long> {


  //This transforms into SQL: SELECT * FROM profile WHERE email = ?     ? means whatever we pass
  @Query("SELECT s FROM Profile s WHERE s.userName = ?1")   //JBQL
  Optional<Profile> findProfileByuserName(String userName);

}
