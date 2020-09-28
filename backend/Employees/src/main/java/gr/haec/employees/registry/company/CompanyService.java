package gr.haec.employees.registry.company;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper mapper;

    public List<CompanyResponse> getCompanies(){
        return companyRepository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public CompanyResponse getCompany(Long id){
        return mapper.toResponse(companyRepository.getOne(id));
    }

}
