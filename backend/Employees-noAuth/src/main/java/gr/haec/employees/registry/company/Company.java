package gr.haec.employees.registry.company;

import gr.haec.employees.registry.department.Department;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String taxNumber;

    @OneToMany(mappedBy = "company")
    private List<Department> departmentList;
}
