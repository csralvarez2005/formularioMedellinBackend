package crud.personaBackend.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String phone;
    private String city;
    private String course;
    private String note;

    private LocalDateTime registrationDate;
    private String status;
}
