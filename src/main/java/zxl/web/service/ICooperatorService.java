package zxl.web.service;

import zxl.web.domain.Cooperator;
import zxl.web.domain.User;

import java.util.List;

public interface ICooperatorService {

   public List<Cooperator> queryAll();

   public Cooperator select(int cid);

   public void register(Cooperator cooperator, User user);

   public int update(Cooperator cooperator);
}
