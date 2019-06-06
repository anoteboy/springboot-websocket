package com.white.springbootwebsocket.server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public Object socket(@PathVariable(value = "cid") String cid, Model model) {
        ModelAndView mav = new ModelAndView("index");
        model.addAttribute("cid", cid);
        return "index.btl";
    }

    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public Object pushToWeb(@PathVariable String cid, String message) {
        WebSocketServer.sendInfo(message, cid);
        return cid;
    }
}