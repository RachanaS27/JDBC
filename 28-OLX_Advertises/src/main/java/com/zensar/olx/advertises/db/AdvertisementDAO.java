package com.zensar.olx.advertises.db;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.olx.advertises.bean.Advertisement;

@Repository
public interface AdvertisementDAO extends JpaRepository<Advertisement, Integer>{

}
