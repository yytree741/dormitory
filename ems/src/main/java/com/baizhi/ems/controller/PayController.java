package com.baizhi.ems.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Controller
@RequestMapping("pay")
public class PayController {

//    public static void main(String[] args) {
//        String order_id = "123456";
//        String order_type = "wechat";
//        String order_price = "6.66";
//        String order_name = "学习资料";
//        String x = DigestUtils.md5DigestAsHex((order_id + order_price).getBytes()) + "xiaochen2018";
//        String sign = DigestUtils.md5DigestAsHex(x.getBytes());
//        String redirect_url = "http://c285v7.natappfree.cc/ems/pay/payok";
//        String extension = "";
//        RestTemplate restTemplate = new RestTemplate();
//        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
//        requestEntity.add("order_id", order_id);
//        requestEntity.add("order_type", order_type);
//        requestEntity.add("order_price", order_price);
//        requestEntity.add("order_name", order_name);
//        requestEntity.add("sign", sign);
//        requestEntity.add("redirect_url", redirect_url);
//        requestEntity.add("extension", extension);
//
//        String s = restTemplate.postForObject("http://127.0.0.1:7001/api/order", requestEntity, String.class);
//        System.out.println(s);
//
//    }

    @GetMapping("pay")
    public String pay(Model model) {
        String order_id = "123456";
        String order_type = "wechat";
        String order_price = "6.66";
        String order_name = "学习资料";
        String x = DigestUtils.md5DigestAsHex((order_id + order_price).getBytes()) + "xiaochen2018";
        String sign = DigestUtils.md5DigestAsHex(x.getBytes());
        String redirect_url = "http://c285v7.natappfree.cc/ems/pay/payok";
        String extension = "";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("order_id", order_id);
        requestEntity.add("order_type", order_type);
        requestEntity.add("order_price", order_price);
        requestEntity.add("order_name", order_name);
        requestEntity.add("sign", sign);
        requestEntity.add("redirect_url", redirect_url);
        requestEntity.add("extension", extension);

        String s = restTemplate.postForObject("http://127.0.0.1:7001/api/order", requestEntity, String.class);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);
        model.addAttribute("pay",jsonObject);


        return "ok";
    }

    @GetMapping("payok")
    public String payok(Model model, Date created_at, Date updated_at, String pay_status, String order_price, String qr_url) {
        System.out.println("created_at = " + created_at);
        System.out.println("qr_url = " + qr_url);
        model.addAttribute("src", qr_url);
        return "ok";
    }


}
