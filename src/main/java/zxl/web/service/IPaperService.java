package zxl.web.service;

import zxl.web.domain.Paper;

import java.util.Date;
import java.util.List;

public interface IPaperService {
    public List<Paper> queryAll();

    public Paper selectPaper(int pid);

    public int update(Paper paper);

    public int save(Paper paper);

    //返回paperid
    public int selectPid(Paper paper);

    public void deleteByPid(int pid);

    //根据出版日期返回这段日期内的所有论文
    public List<Paper> selectPaperbyTime(Date time);
}
