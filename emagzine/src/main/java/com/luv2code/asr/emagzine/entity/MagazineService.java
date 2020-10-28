package com.luv2code.asr.emagzine.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MagazineService {
	@Autowired
	MagazineRepository magazineRepository;
	public List<Magazine> getAllMagazines()
    {
        List<Magazine> employeeList = magazineRepository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Magazine>();
        }
    }
	
	public void createMagazine(Magazine entity)  
    {
            Magazine newEntity = new Magazine();
            //newEntity.setMid(entity.getMid());
    		newEntity.setMname(entity.getMname());
    		newEntity.setMtype(entity.getMtype());
    		newEntity.setMcategory(entity.getMcategory());
    		newEntity.setMdate(entity.getMdate());
    		newEntity.setMlanguage(entity.getMlanguage()); 
            //newEntity = magazineRepository.save(newEntity);
             
            entity=magazineRepository.save(entity);
            System.out.println("New Magazine Created by id: "+newEntity.getMid());
            
    }
	public List<Magazine> listAll() {
	    List<Magazine> counts = new ArrayList<>();
	    magazineRepository.findAll().forEach(counts::add);
	    return counts;
	}
}
