package home.application.controller;

import home.application.service.HelloService;
import home.application.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public String hello(){
        LogUtil.logDebug(HelloController.class,"with feign");
        return service.hello();
    }
}
