package com.example.userProfiles.userProfile;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//API LAYER: GET, POST, PUT, DELETE
@RestController
//Sets path for website. so instead of just,
//localhost8080 it is localhost8080/api/v1/profile
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

  //Refer to ProfileService content for how this is instantiated
  private final ProfileService profileService;

  @Autowired  //ProfileService will be instantiated for us and injected into constructor
  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }

  //Get Mapping
  @GetMapping
  public List<Profile> getProfiles() {
    return profileService.getProfiles();
  }


  @GetMapping("/{userName}")
  public List<Profile> getProfilesByUserName(@PathVariable String userName) {
    return profileService.findByUserName(userName);
  }


  @PostMapping
  public void registerNewProfile(
      @RequestBody Profile profile) {   //Take Requestbody JSON from postman and set it to profile
    profileService.addNewProfile(profile);
  }

  @PutMapping(path = "/{userName}")
  public void updateProfile(
      @PathVariable String userName,
      //@RequestParam(required = false) String userName,
      @RequestParam(required = false) String password,
      @RequestParam(required = false) String fullName,
      @RequestParam(required = false) String altEmail,
      @RequestParam(required = false) String homeAddress) {
    //userName not needed since it can't be changed.
//    profileService.updateProfile(id, userName, password, fullName, altEmail, homeAddress);
    profileService.updateProfile(userName, password, fullName, altEmail, homeAddress);
  }
}
