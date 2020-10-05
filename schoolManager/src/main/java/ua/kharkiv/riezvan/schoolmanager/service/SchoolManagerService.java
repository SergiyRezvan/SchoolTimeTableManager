package ua.kharkiv.riezvan.schoolmanager.service;

import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelPartialUpdateRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRQ;
import ua.kharkiv.riezvan.schoolmanager.api.models.SchoolModelRS;

import java.util.List;

public interface SchoolManagerService {

    SchoolModelRS save(SchoolModelRQ schoolModelRQ);
    SchoolModelRS getSchool(String restName);
    List<SchoolModelRS> getAllSchools();
    SchoolModelRS update(SchoolModelPartialUpdateRQ request, String restName);
    void delete(String restName);
    void checkThatSchoolExists(String restName);

}
