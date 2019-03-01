package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Company;
import zxl.web.mapper.CompanyMapper;
import zxl.web.service.ICompanyService;
import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    CompanyMapper mapper;

    @Override
    public List<Company> queryAll() {
        return mapper.queryAll();
    }
}
