package cn.yinjiahui.group_purchase.service;


import cn.yinjiahui.group_purchase.po.UserInfo;

public interface UserService {


    String login(String phone, String password);

    Integer getCurrentUserId();

    UserInfo getUserByPhone(String phone);

    UserInfo getUserById(Integer id);

    void updateUserInfo(UserInfo userInfo);

}
