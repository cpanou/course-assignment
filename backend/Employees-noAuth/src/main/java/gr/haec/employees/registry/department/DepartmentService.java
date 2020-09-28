package gr.haec.employees.registry.department;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper mapper;

    public List<DepartmentResponse> getDepartments(){
        return departmentRepository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public DepartmentResponse getDepartment(Long id){
        return mapper.toResponse(departmentRepository.getOne(id));
    }

    public List<DepartmentResponse> getBySector(String sector) {
        return departmentRepository.findAllBySector(sector).stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
