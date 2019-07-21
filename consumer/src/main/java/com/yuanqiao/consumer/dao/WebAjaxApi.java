package com.yuanqiao.consumer.dao;

import com.yuanqiao.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@FeignClient(name = "httpService", url = "http://localhost:8080/")
public interface WebAjaxApi {

    @RequestMapping(value = "WebAjax/MyServlet", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json;charset=UTF-8")
//    public String getUserById(@RequestBody String id);
    public String getUserById(@RequestBody User user);

//    public String getUserById(@RequestParam("id") String id);
}
