package crud.personaBackend.Service;

import crud.personaBackend.DTO.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> listAll();
    StudentDTO save(StudentDTO studentDTO);
    StudentDTO findById(Long id);
    StudentDTO update(Long id, StudentDTO studentDTO);
    void delete(Long id);
}
