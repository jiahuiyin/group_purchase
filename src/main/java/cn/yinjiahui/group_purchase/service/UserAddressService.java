package cn.yinjiahui.group_purchase.service;


import cn.yinjiahui.group_purchase.po.UserAddress;

import java.util.List;

public interface UserAddressService {
    void save(UserAddress userAddress);

    List<UserAddress> selectByUId();

    void deleteById(Integer id);
}
