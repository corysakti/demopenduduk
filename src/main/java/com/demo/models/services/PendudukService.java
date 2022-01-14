package com.demo.models.services;

import javax.transaction.Transactional;

import com.demo.models.Penduduk;
import com.demo.models.repos.PendudukRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PendudukService {
    
    @Autowired
    private PendudukRepo pendudukRepo;

    public Penduduk save(Penduduk penduduk){
        return pendudukRepo.save(penduduk);
    }

        //cari data berdasar id
        public Penduduk findOne(Long id){
            return pendudukRepo.findById(id).get();
        }
    
        //show semua data
        public Iterable<Penduduk> findAll(){
            return pendudukRepo.findAll();
        }
    
        //delete data berdasar id
        public void removeOne(Long id){
            pendudukRepo.deleteById(id);
        }
}
