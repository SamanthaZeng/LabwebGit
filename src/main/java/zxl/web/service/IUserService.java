package zxl.web.service;

import zxl.web.domain.User;

public interface IUserService {
    public void register(User user);//注册方法

    public User selectuser(int id);

}
