package zxl.web.service;

import zxl.web.domain.Researcharea;

import java.util.List;

public interface IResearchareaService {
    List<Researcharea> queryAll();

    void delete(int rid);

    Researcharea selectResearcharea(int rid);

    void insert(Researcharea researcharea);

    void update(Researcharea researcharea);
}
