package home.application.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="service-hi",fallback=HelloHyStrixService.class)
public interface HelloService {
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    String hello();
}
