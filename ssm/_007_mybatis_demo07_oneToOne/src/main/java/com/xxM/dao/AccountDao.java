package com.xxM.dao;

import com.xxM.domain.Account02;
import com.xxM.domain.AccountCustom;

import java.util.List;

public interface AccountDao {
    List<AccountCustom> findAccountList();
    List<Account02> findAccountList02();
}
