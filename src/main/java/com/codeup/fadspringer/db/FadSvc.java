package com.codeup.fadspringer.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FadSvc {
    private Fads fadsDao;

    @Autowired
    public FadSvc(Fads fadsDao) {
        this.fadsDao = fadsDao;
    }

    public List<Fad> findAll() {
        Iterable<Fad> fadsDaoAll = fadsDao.findAll();
        List<Fad> fads = new ArrayList<>();
        fadsDaoAll.forEach(fads::add);
        return fads;
    }

    public Fad save(Fad fad) {
        fadsDao.save(fad);
        return fad;
    }

    public Fad findOne(long id) {
        return fadsDao.findOne(id);
    }
//
//    private void createAds() {
//        // create some ad objects and add them to the ads list
//        // with the save method
//    }
}