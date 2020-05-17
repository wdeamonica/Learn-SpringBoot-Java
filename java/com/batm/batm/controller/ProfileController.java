/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.batm.batm.controller;

import com.batm.batm.model.Profile;
import com.batm.batm.services.ProfileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ayuni
 */
@Controller
public class ProfileController {
    private ProfileServices profileServices;
    @Autowired
    public void setProfileServices(ProfileServices profileServices) {
        this.profileServices = profileServices;
    }
    
      @RequestMapping("/profile")
    public String ProfileList(Model model) {
        model.addAttribute("profile", profileServices.listProfile());
        return "profile";
    }
    
    @RequestMapping(value = "/profile/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model){
        model.addAttribute("profile", new Profile());
        return "formProfile";
    }
    
    @RequestMapping(value = "/profile/create", method = RequestMethod.POST)
    public String simpanDataProfile(Model model, Profile profile){
    model.addAttribute("profile", profileServices.saveOrUpdate(profile));
    return "redirect:/profile";
    }
    
    @RequestMapping(value = "/profile/edit/{user_id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer user_id, Model model){
    model.addAttribute("profile" , profileServices.getProfileId(user_id));
    return "formProfile";
    }
    
     @RequestMapping(value = "/profile/hapus/{user_id}")
    public String hapus(@PathVariable Integer user_id){
    profileServices.hapus(user_id);
    return "redirect:/profile";
    }
    
}
