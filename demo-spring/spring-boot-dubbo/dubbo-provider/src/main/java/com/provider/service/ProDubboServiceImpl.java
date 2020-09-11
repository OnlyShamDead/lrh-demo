package com.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.common.dubbo.bo.UserBO;
import com.common.dubbo.service.DubboService;
import org.springframework.stereotype.Component;

@Service // dubbo的service注解，不具备spring的@service注解的功能
@Component
public class ProDubboServiceImpl implements DubboService {

    public void name(UserBO ub) {
        ub.setName("hello");
    }

    public void age(UserBO ub) {
        ub.setAge(18);
    }

    public void sex(UserBO ub) {
        ub.setSex("女");
    }

    public UserBO info() {
        UserBO ub = new UserBO();
        name(ub);
        sex(ub);
        age(ub);
        return ub;
    }
}
