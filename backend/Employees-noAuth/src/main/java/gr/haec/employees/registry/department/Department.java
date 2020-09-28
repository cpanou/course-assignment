package gr.haec.employees.registry.department;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import gr.haec.employees.registry.company.Company;
import gr.haec.employees.registry.employee.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SectorEnum sector;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Employee> employeeList;

}
