package zxl.web.service;

import zxl.web.domain.Classes;
import zxl.web.domain.ClassesChart;

import java.util.List;

public interface IClassesService {
    public List<Classes>queryAll();
    //查询报表的方法
    public List<ClassesChart> queryClassesChart();
}
