/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.batm.batm.dao;

import com.batm.batm.model.Profile;
import com.batm.batm.services.ProfileServices;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ayuni
 */
@Service
public class ProfileDao implements ProfileServices{
     private EntityManagerFactory emf;
    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public List<Profile> listProfile() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Profile", Profile.class).getResultList();
    }

    @Override
    public Profile saveOrUpdate(Profile profile) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Profile saved = em.merge(profile);
    em.getTransaction().commit();
    return saved;
    }
    
    @Override
    public Profile getProfileId(Integer id){
    EntityManager em = emf.createEntityManager();
    return em.find(Profile.class, id);
    }
    
    @Override
    public void hapus(Integer id){
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.remove(em.find(Profile.class, id));
    em.getTransaction().commit();
    }
}
