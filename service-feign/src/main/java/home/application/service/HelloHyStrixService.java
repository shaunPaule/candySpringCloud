package home.application.service;

import home.application.util.LogUtil;
import org.springframework.stereotype.Component;

@Component
public class HelloHyStrixService implements HelloService{
    @Override
    public String hello() {
        LogUtil.logDebug(HelloHyStrixService.class,"from the hystrix for feign");
        return "hystrix happen,feign";
    }
}
