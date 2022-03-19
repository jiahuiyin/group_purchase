package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.MerchantMapper;
import cn.yinjiahui.group_purchase.po.Merchant;
import cn.yinjiahui.group_purchase.po.UserInfo;
import cn.yinjiahui.group_purchase.service.MerchantService;
import cn.yinjiahui.group_purchase.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    UserService userService;
    @Autowired
    MerchantMapper merchantMapper;

    @Override
    public Integer registerMerchant(String image, String name, String description) {
        Integer uid = userService.getCurrentUserId();
        List<Merchant> merchants = merchantMapper.selectByMap(new HashMap<>() {
            {
                put("user_id", uid);
            }
        });
        if (merchants != null && merchants.size() != 0) {
            Merchant merchant = merchants.get(0);
            merchant.setImage(image);
            merchant.setName(name);
            merchant.setDescription(description);
            merchantMapper.updateById(merchant);
            return merchant.getId();
        } else {
            UserInfo user = userService.getUserById(uid);
            Merchant merchant = new Merchant(null, uid, image, name, description, user.getPhone(), null, null);
            return merchantMapper.insert(merchant);
        }
    }
}

