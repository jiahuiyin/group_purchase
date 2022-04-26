package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Merchant;

import java.util.List;

public interface MerchantService {
    Integer registerMerchant(String image, String name, String description);

    Merchant getMerchant(Integer merchantId);

    List<Merchant> searchMerchant(String name);

    List<Merchant> mget();

    Merchant getMyMerchant();
}
