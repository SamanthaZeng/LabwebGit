package zxl.web.mapper;

import zxl.web.domain.Company;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer coid);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> queryAll();
}