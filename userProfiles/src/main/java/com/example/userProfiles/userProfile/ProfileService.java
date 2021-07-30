package com.example.userProfiles.userProfile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service  //Service annotation tells the @Autowired from controller that this class will be the bean
public class ProfileService {

  private final ProfileRepository profileRepository;

  @Autowired
  public ProfileService(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }


  //This will return the list of Profiles in the database
  public List<Profile> getProfiles() {
    return profileRepository.findAll();
  }


  //Returns a list of users with the same userName(Which wont happen since userName is unique
  public List<Profile> findByUserName(String userName) {//Profile profile

    return profileRepository.findByUserName(userName);

  }


  //This will add a new profile to the database
  public void addNewProfile(Profile profile) {

    Optional<Profile> profileByUserName = profileRepository
        .findProfileByuserName(profile.getUserName());

    //Checks to see if the username is in database
    if (profileByUserName.isPresent()) {
      throw new IllegalStateException("User name taken!");
    }

    profileRepository.save(profile);

    System.out.println(profile);
  }


  @Transactional
  public void updateProfile(Long profileId, String password,
      String fullName, String altEmail, String homeAddress) {

    Profile profile = profileRepository.findById(profileId)
        .orElseThrow(() -> new IllegalStateException(
            "Profile with ID " + profileId + " does not exist. <- make it by username not id")
        );


    //Username not included since its not supposed to be changed
    //Password
    if (password != null && password.length() > 0 &&
        !Objects.equals(profile.getPassword(), password)) {
      profile.setPassword(password);
    }


    //Full Name - First and Last name
    if (fullName != null && fullName.length() > 0 &&
        !Objects.equals(profile.getFullName(), fullName)) {
      profile.setFullName(fullName);
    }


    //Alternate email (Not the username)
    if (altEmail != null && altEmail.length() > 0 &&
        !Objects.equals(profile.getAltEmail(), altEmail)) {
      profile.setAltEmail(altEmail);
    }


    //Home address
    if (homeAddress != null && homeAddress.length() > 0 &&
        !Objects.equals(profile.getHomeAddress(), homeAddress)) {
      profile.setHomeAddress(homeAddress);
    }

  }
}
