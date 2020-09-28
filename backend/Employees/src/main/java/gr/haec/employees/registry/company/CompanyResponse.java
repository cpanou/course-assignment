package gr.haec.employees.registry.company;

import gr.haec.employees.registry.department.DepartmentResponse;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

    private Long id;
    private String name;
    private String taxNumber;
    private List<DepartmentResponse> departmentList;
}
