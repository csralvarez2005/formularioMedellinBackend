package crud.personaBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "students") // Specify the table name here
@Getter
@Setter
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String city;
    private String course;
    private String note;

    // Automatically set the registration date when the entity is persisted
    @Column(name = "registration_date", nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    // Set default status as "interesado"
    @Column(nullable = false)
    private String status = "interesado";

    @PrePersist
    protected void onCreate() {
        this.registrationDate = LocalDateTime.now();
    }
}
