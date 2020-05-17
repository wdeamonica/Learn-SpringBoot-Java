/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.batm.batm.services;

import com.batm.batm.model.Profile;
import java.util.List;

/**
 *
 * @author ayuni
 */
public interface ProfileServices {
      List <Profile> listProfile();
    
    Profile saveOrUpdate(Profile profile);
    Profile getProfileId(Integer user_id);
    void hapus(Integer user_id);
    
}
