package ua.kharkiv.riezvan.schoolmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.converters.Converters;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.db.models.SchoolEntity;
import ua.kharkiv.riezvan.schoolmanager.db.repository.SchoolRepository;
import ua.kharkiv.riezvan.schoolmanager.exception.SchoolNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SchoolManagerService {

    @Autowired
    private SchoolRepository repository;

    @Transactional
    public SchoolModelRS save(SchoolModelRQ schoolModelRQ) {
        SchoolEntity schoolEntity = Converters.convertRequestToDbEntity(schoolModelRQ);
        SchoolEntity savedEntity = repository.save(schoolEntity);
        return Converters.convertEntityToRs(savedEntity);
    }

    public SchoolModelRS getSchool(String restName) {
        Optional<SchoolEntity> schoolEntity = repository.findByRestName(restName);
        return schoolEntity.map(Converters::convertEntityToRs)
                .orElseThrow(() -> new SchoolNotFoundException("The requested school does not exists."));
    }

    public List<SchoolModelRS> getAllSchools() {
        var schools = new ArrayList<SchoolModelRS>();
        repository.findAll().forEach(dbResult -> {
            schools.add(Converters.convertEntityToRs(dbResult));
        });
        return schools;
    }

    @Transactional
    public SchoolModelRS update(SchoolModelRQ request, String restName) {
        Optional<SchoolEntity> schoolEntityOpt = repository.findByRestName(restName);
        schoolEntityOpt.orElseThrow(() -> new SchoolNotFoundException("The requested school does not exists."));
        // TODO: Add partially update mapping
        SchoolEntity entityToUpdate = Converters.convertRequestToDbEntity(request);
        entityToUpdate.setId(schoolEntityOpt.get().getId());
        return Converters.convertEntityToRs(repository.save(entityToUpdate));
    }

    @Transactional
    public void delete(String restName) {
        Optional<SchoolEntity> schoolEntityOpt = repository.findByRestName(restName);
        schoolEntityOpt.orElseThrow(() -> new SchoolNotFoundException("The requested school does not exists."));
        repository.deleteById(schoolEntityOpt.get().getId());
    }

}
