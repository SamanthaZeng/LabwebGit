package zxl.web.service;

import zxl.web.domain.Researcharea;

import java.util.List;

public interface IResearchareaService {
    List<Researcharea> queryAll();

    void delete(int rid);
    //根据rid返回对应项全部内容
    Researcharea selectResearcharea(int rid);

    void insert(Researcharea researcharea);

    void update(Researcharea researcharea);

    Researcharea queryinfo();
}
