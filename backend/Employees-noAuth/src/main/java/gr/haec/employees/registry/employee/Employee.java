package gr.haec.employees.registry.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gr.haec.employees.registry.department.Department;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String address;
    private String phone;

    @CreationTimestamp
    private LocalDateTime hireDate;
    private LocalDateTime leaveDate;
    private String position;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;
}