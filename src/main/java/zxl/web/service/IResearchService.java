package zxl.web.service;

import zxl.web.domain.Researcharea;

public interface IResearchService {
    //根据rid返回对应项全部内容
    public Researcharea selectResearch(int rid);
}
