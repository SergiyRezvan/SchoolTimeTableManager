package ua.kharkiv.riezvan.schoolmanager.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelPartialUpdateRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.converters.Converters;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.db.models.SchoolEntity;
import ua.kharkiv.riezvan.schoolmanager.db.repository.SchoolRepository;
import ua.kharkiv.riezvan.schoolmanager.exception.SchoolNotFoundException;
import ua.kharkiv.riezvan.schoolmanager.service.SchoolManagerService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class SchoolManagerServiceImpl implements SchoolManagerService {

    private final SchoolRepository repository;

    @Transactional
    public SchoolModelRS save(SchoolModelRQ schoolModelRQ) {
        SchoolEntity schoolEntity = Converters.convertRequestToDbEntity(schoolModelRQ);
        SchoolEntity savedEntity = repository.save(schoolEntity);
        return Converters.convertEntityToRs(savedEntity);
    }

    public SchoolModelRS getSchool(String restName) {
        checkThatSchoolExists(restName);
        SchoolEntity schoolEntity = repository.findByRestName(restName);
        return Converters.convertEntityToRs(schoolEntity);
    }

    public List<SchoolModelRS> getAllSchools() {
        var schools = new ArrayList<SchoolModelRS>();
        repository.findAll().forEach(dbResult -> {
            schools.add(Converters.convertEntityToRs(dbResult));
        });
        return schools;
    }

    @Transactional
    public SchoolModelRS update(SchoolModelPartialUpdateRQ request, String restName) {
        checkThatSchoolExists(restName);
        SchoolEntity entityToUpdate = repository.findByRestName(restName);
        Converters.copyUpdatedFields(entityToUpdate, request);
        return Converters.convertEntityToRs(repository.save(entityToUpdate));
    }

    @Transactional
    public void delete(String restName) {
        checkThatSchoolExists(restName);
        SchoolEntity schoolEntityOpt = repository.findByRestName(restName);

        // TODO: Delete all subsequent resources
        repository.deleteById(schoolEntityOpt.getId());
    }

    @Override
    public void checkThatSchoolExists(String restName) {
        if (!repository.existsByRestName(restName)) {
            throw new SchoolNotFoundException(String.format("The requested school %s does not exists.", restName));
        }
    }

}
