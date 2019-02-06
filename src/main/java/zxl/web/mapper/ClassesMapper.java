package zxl.web.mapper;

import zxl.web.domain.Classes;
import zxl.web.domain.ClassesChart;

import java.util.List;

public interface ClassesMapper {
    //查询所有的数据
    public List<Classes> queryAll();
    //查询报表的方法
    public List<ClassesChart> queryClassesChart();
}
