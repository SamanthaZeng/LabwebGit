package zxl.web.service;

import java.util.List;

import zxl.web.domain.Company;

public interface ICompanyService {

    public List<Company> queryAll();

    public Company selectCompany(int coid);

    public void insert(Company company);

    public void update(Company company);

}
