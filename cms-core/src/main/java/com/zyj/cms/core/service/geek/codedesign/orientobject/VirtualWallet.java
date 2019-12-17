package com.zyj.cms.core.service.geek.codedesign.orientobject;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;

/**
 * 基于充血模型的虚拟钱包
 * Author: zhouyajun
 * Date: 2019-12-16
 */
public class VirtualWallet {
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;
    public VirtualWallet(Long preAllocatedId){
        this.id = preAllocatedId;
    }

    public BigDecimal balance(){
        return this.balance;
    }

    public void debit(BigDecimal amount) throws InsufficientResourcesException {
        if (this.balance.compareTo(amount) < 0){
            throw new InsufficientResourcesException("余额小于体现金额，无法进行提现操作");
        }
        this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) throws InsufficientResourcesException {
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new InsufficientResourcesException("充值金额不能小于0");
        }
        this.balance.add(amount);
    }
}
