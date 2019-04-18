package zxl.web.service;

import zxl.web.domain.ProResearchKey;

import java.util.List;

public interface IProResearchService {
    //通过研究领域来查找项目
    public List<ProResearchKey> findByRid(int rid);
}
