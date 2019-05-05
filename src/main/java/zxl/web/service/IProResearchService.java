package zxl.web.service;

import zxl.web.domain.ProResearchKey;
import zxl.web.domain.Researcharea;

import java.util.List;

public interface IProResearchService {
    //通过研究领域来查找项目
    public List<ProResearchKey> findByRid(int rid);

    public List<Researcharea> findByProid(int proid);

    public void insert(ProResearchKey proResearchKey);

    public void deleteByProid(int proid);
}
