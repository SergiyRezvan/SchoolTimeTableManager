package ua.kharkiv.riezvan.lessonmanager.classes.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassRequest;
import ua.kharkiv.riezvan.lessonmanager.classes.api.models.ClassResponse;
import ua.kharkiv.riezvan.lessonmanager.classes.db.entity.Class;
import ua.kharkiv.riezvan.lessonmanager.classes.db.repository.ClassRepository;
import ua.kharkiv.riezvan.lessonmanager.converters.Converters;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClassService {

    private final ClassRepository classRepository;

    public List<ClassResponse> getAllClasses() {
        var classes = classRepository.findAll();
        var classRs = new ArrayList<ClassResponse>();
        classes.forEach(item -> classRs.add(Converters.convertDbToRS(item)));
        return classRs;
    }

    public ClassResponse getClass(Long id) {
        Optional<Class> classOptional = classRepository.findById(id);
        return classOptional.map(Converters::convertDbToRS)
                .orElseThrow(() -> new NoSuchElementException("No class with such id"));
    }

    public ClassResponse createNew(ClassRequest request) {
        Class dbEntity = Converters.convertRqToDbEntity(request);
        return Converters.convertDbToRS(classRepository.save(dbEntity));
    }

    public ClassResponse updateClass(ClassRequest request, Long classId) {
        Class dbEntity = classRepository.findById(classId)
                .orElseThrow(() -> new NoSuchElementException("No class with such id"));
        dbEntity.setName(request.getName());
        return Converters.convertDbToRS(classRepository.save(dbEntity));
    }

    public void deleteClass(Long classId) {
        if (classRepository.existsById(classId)) {
            classRepository.deleteById(classId);
        }
        throw new NoSuchElementException("No class with such id");
    }

}
