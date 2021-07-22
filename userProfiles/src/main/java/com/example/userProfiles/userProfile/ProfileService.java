package com.example.userProfiles.userProfile;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service  //Service annotation tells the @Autowired from controller that this class will be the bean
public class ProfileService {

  private final ProfileRepository profileRepository;

  @Autowired
  public ProfileService(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }


  //This will return the list of Profiles in the database
  public List<Profile> getProfiles(){

    return profileRepository.findAll();
  }


  //This will add a new profile to the database
  public void addNewProfile(Profile profile) {

    Optional<Profile> profileByuserName = profileRepository
        .findProfileByuserName(profile.getUserName());


    //Checks to see if the username is in database
    if(profileByuserName.isPresent()){
      throw new IllegalStateException("User name taken!");
    }


    profileRepository.save(profile);

    System.out.println(profile);
  }
}
