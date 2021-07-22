package com.example.userProfiles.userProfile;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//API LAYER: GET, POST, PUT, DELETE
@RestController
//Sets path for website. so instead of just,
//localhost8080 it is localhost8080/api/v1/profile
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

  //Refer to ProfileService content for how this is instantiated
  private final ProfileService profileService;

  @Autowired  //Profileservice will be instantiated for us and injected into constructor
  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }


  @GetMapping
  public List<Profile> getProfiles(){
    return profileService.getProfiles();
  }

  @PostMapping
  public void registerNewProfile(@RequestBody Profile profile){   //Take Requestbody JSON from postman and set it to profile
    profileService.addNewProfile(profile);
  }

}
