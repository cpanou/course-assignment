package gr.haec.employees.registry.department;

import gr.haec.employees.registry.employee.EmployeeResponse;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    private Long id;
    private String name;
    private SectorEnum sector;
    private List<EmployeeResponse> employeeList;

}
