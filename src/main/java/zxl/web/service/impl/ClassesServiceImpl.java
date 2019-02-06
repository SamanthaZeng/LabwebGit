package zxl.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.web.domain.Classes;
import zxl.web.domain.ClassesChart;
import zxl.web.mapper.ClassesMapper;
import zxl.web.service.IClassesService;

import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {
    @Autowired
    ClassesMapper mapper;

    @Override
    public List<Classes> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public List<ClassesChart> queryClassesChart() {
        return mapper.queryClassesChart();
    }

}
