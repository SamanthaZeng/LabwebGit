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

    @Override
    public Company selectCompany(int coid) {
        return mapper.selectByPrimaryKey(coid);
    }

    @Override
    public void insert(Company company) {
        mapper.insertSelective(company);
    }

    @Override
    public void update(Company company) {
        mapper.updateByPrimaryKeySelective(company);
    }

    @Override
    public void delete(int coid) {
        mapper.deleteByPrimaryKey(coid);
    }
}
