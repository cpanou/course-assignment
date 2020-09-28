package gr.haec.employees.registry.department;

import gr.haec.employees.registry.employee.EmployeeMapper;
import gr.haec.employees.registry.employee.EmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentMapper {

    private final EmployeeMapper employeeMapper;

    private final Function<Department, DepartmentResponse> toResponse = department -> DepartmentResponse.builder()
            .id(department.getId())
            .employeeList(getEmployees(department))
            .name(department.getName())
            .sector(department.getSector())
            .build();

    private List<EmployeeResponse> getEmployees(Department department) {
        return department.getEmployeeList().stream().map(employeeMapper::toResponse).collect(Collectors.toList());
    }

    public DepartmentResponse toResponse(Department employee) {
        return  this.toResponse.apply(employee);
    }

}
