package ua.kharkiv.riezvan.schoolmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.schoolmanager.Converters;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;
import ua.kharkiv.riezvan.schoolmanager.db.models.SchoolEntity;
import ua.kharkiv.riezvan.schoolmanager.db.repository.SchoolRepository;

@Service
public class SchoolManagerService {

    @Autowired
    private SchoolRepository repository;

    public SchoolModelRS save(SchoolModelRQ schoolModelRQ) {
        SchoolEntity schoolEntity = Converters.convertRequestToDbEntity(schoolModelRQ);
        SchoolEntity savedEntity = repository.save(schoolEntity);
        return Converters.convertEntityToRs(savedEntity);
    }

}
