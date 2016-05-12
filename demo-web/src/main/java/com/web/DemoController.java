package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author boyue.lby
 * @date 16/4/22 上午11:18
 */
@Controller public class DemoController {
    @RequestMapping("/simpletest.do") public void test(Model model, HttpServletRequest request,
        @RequestParam(value = "message", required = false) String message,
        HttpServletResponse response) {
        System.out.println(message);
        System.out.printf("qwe");
    }

}
