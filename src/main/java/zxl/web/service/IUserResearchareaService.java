package zxl.web.service;

import zxl.web.domain.User;
import zxl.web.domain.Researcharea;
import zxl.web.domain.UserResearchKey;

import java.util.List;

public interface IUserResearchareaService {
    void deleteByPrimaryKey(UserResearchKey key);

    void insert(UserResearchKey record);

    List<UserResearchKey> selectResearchare(int id);

    void deleteByUser(int id);
    //根据研究领域返回所有相关教师
    public List<UserResearchKey> queryAll(int rid);
}
