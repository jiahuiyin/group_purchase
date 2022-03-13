package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.UserAddressMapper;
import cn.yinjiahui.group_purchase.po.UserAddress;
import cn.yinjiahui.group_purchase.service.UserAddressService;
import cn.yinjiahui.group_purchase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserAddressServiceImp implements UserAddressService {

    @Autowired
    UserAddressMapper userAddressMapper;

    @Autowired
    UserService userService;

    @Override
    public void save(UserAddress userAddress) {
        if (userAddress.getId() == null) {
            userAddressMapper.insert(userAddress);
        } else {
            userAddressMapper.updateById(userAddress);
        }
    }

    @Override
    public List<UserAddress> selectByUId() {
        Integer uid = userService.getCurrentUserId();
        return userAddressMapper.selectByMap(new HashMap<>() {
            {
                put("user_id", uid);
            }
        });
    }

    @Override
    public void deleteById(Integer id) {
        userAddressMapper.deleteById(id);
    }
}
