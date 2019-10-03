package com.xxM.dao;

import com.xxM.domain.Account;
import com.xxM.domain.User;

import java.util.List;

public interface AccountDao {
    List<Account> findAccountList();
    User findByUid(Integer uid);
}
