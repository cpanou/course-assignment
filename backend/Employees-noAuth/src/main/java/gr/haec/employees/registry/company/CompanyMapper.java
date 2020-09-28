package gr.haec.employees.registry.company;

import gr.haec.employees.registry.department.DepartmentMapper;
import gr.haec.employees.registry.department.DepartmentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyMapper {

    private final DepartmentMapper departmentMapper;

    private final Function<Company, CompanyResponse> toResponse = company -> CompanyResponse.builder()
            .id(company.getId())
            .name(company.getName())
            .taxNumber(company.getTaxNumber())
            .departmentList(getDepartments(company))
            .build();

    private List<DepartmentResponse> getDepartments(Company company) {
        return company.getDepartmentList().stream().map(departmentMapper::toResponse).collect(Collectors.toList());
    }

    public CompanyResponse toResponse(Company company) {
        return this.toResponse.apply(company);
    }

}
