package com.yuanqiao.consumer.controller;

import com.yuanqiao.consumer.dao.WebAjaxApi;
import com.yuanqiao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class ServletController {
    private String url = "http://localhost:8080/WebAjax/MyServlet";

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private WebAjaxApi webAjaxApi;

    @GetMapping("/WebAjax/MyServlet")
    public void getUserById(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream outputStream=null;
        try {
//        return restTemplate.postForObject(url,id,User.class);
            User user=new User(1,"yuanqiao","男",27);
//            String httpServletRequest = webAjaxApi.getUserById("1");
            String httpServletRequest = webAjaxApi.getUserById(user);

            System.out.println("---------------开始打印东西-----------------");
            System.out.println(httpServletRequest);
            outputStream= response.getOutputStream();
            outputStream.print("this call is ok");
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
