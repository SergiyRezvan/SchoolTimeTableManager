package ua.kharkiv.riezvan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.converters.Converters;
import ua.kharkiv.riezvan.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.activitymanager.db.models.SchoolEntity;
import ua.kharkiv.riezvan.activitymanager.db.repository.SchoolRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SchoolManagerService {

    @Autowired
    private SchoolRepository repository;

    public SchoolModelRS save(SchoolModelRQ schoolModelRQ) {
        SchoolEntity schoolEntity = Converters.convertRequestToDbEntity(schoolModelRQ);
        SchoolEntity savedEntity = repository.save(schoolEntity);
        return Converters.convertEntityToRs(savedEntity);
    }

    public SchoolModelRS getSchool(Long schoolId) {
        Optional<SchoolEntity> schoolEntity = repository.findById(schoolId);
        return schoolEntity.map(Converters::convertEntityToRs).orElseThrow();
    }

    public List<SchoolModelRS> getAllSchools() {
        var schools = new ArrayList<SchoolModelRS>();
        repository.findAll().forEach(dbResult -> {
            schools.add(Converters.convertEntityToRs(dbResult));
        });
        return schools;
    }

    public SchoolModelRS update(SchoolModelRQ request, Long schoolId) {
        Optional<SchoolEntity> schoolEntityOpt = repository.findById(schoolId);
        schoolEntityOpt.orElseThrow(NoSuchElementException::new);
        SchoolEntity entityToUpdate = Converters.convertRequestToDbEntity(request);
        return Converters.convertEntityToRs(repository.save(entityToUpdate));
    }

    public void delete(Long schoolId) {
        Optional<SchoolEntity> schoolEntityOpt = repository.findById(schoolId);
        schoolEntityOpt.orElseThrow(NoSuchElementException::new);
        repository.deleteById(schoolId);
    }

}
