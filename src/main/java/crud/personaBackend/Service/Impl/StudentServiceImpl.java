package crud.personaBackend.Service.Impl;

import crud.personaBackend.DTO.StudentDTO;
import crud.personaBackend.Entity.Student;
import crud.personaBackend.Repository.StudentRepository;
import crud.personaBackend.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> listAll() {
        return studentRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        Student student = mapToEntity(studentDTO);
        student.setStatus("interesado");
        student = studentRepository.save(student);
        return mapToDTO(student);
    }

    @Override
    public StudentDTO findById(Long id) {
        return studentRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public StudentDTO update(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(studentDTO.getName());
        student.setPhone(studentDTO.getPhone());
        student.setCity(studentDTO.getCity());
        student.setCourse(studentDTO.getCourse());
        student.setNote(studentDTO.getNote());
        student.setStatus(studentDTO.getStatus()); // Update status if provided

        return mapToDTO(studentRepository.save(student));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setPhone(student.getPhone());
        dto.setCity(student.getCity());
        dto.setCourse(student.getCourse());
        dto.setNote(student.getNote());
        dto.setRegistrationDate(student.getRegistrationDate());
        dto.setStatus(student.getStatus());
        return dto;
    }

    private Student mapToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setCity(dto.getCity());
        student.setCourse(dto.getCourse());
        student.setNote(dto.getNote());
        student.setStatus(dto.getStatus());
        return student;
    }
}
