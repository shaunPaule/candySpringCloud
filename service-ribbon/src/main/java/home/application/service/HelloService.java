package home.application.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import home.application.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate instance;
    @HystrixCommand(fallbackMethod="helloError")
    public String hello(){
        return instance.getForObject("http://service-hi/hello",String.class);
    }

    public String helloError(){
        LogUtil.logDebug(HelloService.class,"hystrix happen");
        return null;
    }
}
