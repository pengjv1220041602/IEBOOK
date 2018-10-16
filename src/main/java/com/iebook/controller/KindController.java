package com.iebook.controller;

import com.iebook.entry.Kind;
import com.iebook.service.KindService;
import com.iebook.utils.Constants;
import com.iebook.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ZhPJ
 * @Date 2018/10/15 001513:07
 * @Version 1.0
 * @Description:
 */
@Controller
@RequestMapping(path = "/kinds")
public class KindController {

    @Autowired
    private KindService kindService;

    @RequestMapping(path = "/kindform")
    public String kindform (    ) {
        return "/kind/kindform";
    }

    @RequestMapping(path = "/addkind", method = RequestMethod.POST)
    @ResponseBody
    public Result addKind (Kind kind) {
        boolean success = kindService.saveOrUpdateKind(kind);
        if (success) {
            return new Result("添加成功！", Constants.Code.SUCCESS_CODE, success, null);
        }
        return new Result("添加失败！", Constants.Code.ERROR_CODE, success, null);
    }

}
