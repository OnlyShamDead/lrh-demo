package com.common.dubbo.service;

import com.common.dubbo.bo.UserBO;

public interface DubboService {

    void name(UserBO ub);

    void age(UserBO ub);

    void sex(UserBO ub);

    UserBO info();

}
