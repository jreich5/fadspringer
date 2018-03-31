package com.codeup.fadspringer.db;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class FadService {
    private CrudRepository<Fad, Long> fadsDao;

    public FadService(CrudRepository<Fad, Long> fadsDao) {
        this.fadsDao = fadsDao;
    }

    public List<Fad> findAll() {
        Iterable<Fad> fadsDaoAll = fadsDao.findAll();
        List<Fad> fads = new ArrayList<>();
        fadsDaoAll.forEach(fads::add);
        return fads;
    }

//    public Fad save(Fad fad) {
//        fad.setId(fad.size() + 1);
//        fad.add(fad);
//        return fad;
//    }
//
//    public Fad findOne(long id) {
//        return fads.get(id - 1);
//    }
//
//    private void createAds() {
//        // create some ad objects and add them to the ads list
//        // with the save method
//    }
}