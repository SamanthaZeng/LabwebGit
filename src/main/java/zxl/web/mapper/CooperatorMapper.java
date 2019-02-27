package zxl.web.mapper;

import zxl.web.domain.Cooperator;

import java.util.List;

public interface CooperatorMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Cooperator record);

    int insertSelective(Cooperator record);

    Cooperator selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Cooperator record);

    int updateByPrimaryKey(Cooperator record);

    List<Cooperator> queryAll();
}