package com.police.controller.copstaffmanagement;

import com.alibaba.fastjson.JSON;
import com.pojo.entity.CopInfoPO;

import com.police.common.util.FastJsonUtil;
import com.police.common.util.ResultBuilder;
import com.police.pojo.dto.PageContentDTO;
import com.police.pojo.dto.copstaff.CopInfoDTO;
import com.police.pojo.entity.copstaff.CopInfoPO;
import com.police.service.copstaff.CopStaffInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("copstaffmanagement")


public class CopStaffInfoController {
    private static final Logger logger = LoggerFactory.getLogger(CopStaffInfoController.class);
    @Autowired
    private CopStaffInfoService copStaffInfoService;

    @ResponseBody
    @RequestMapping(value = "/createcopstaff", method = RequestMethod.POST)
    public String createCopStaff(@RequestBody String payload) {
        logger.info("获取警员列表，2 请求参数：{}", payload);
        CopInfoPO copInfoPO = FastJsonUtil.toBean(payload, CopInfoPO.class);
        Integer resultColumn = mainTaskInfoService.createMainTaskInfo(copInfoPO);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("创建成功");
        } else {
            return ResultBuilder.buildError("创建失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/listcop",method = RequestMethod.POST)
    public String listCopStaff(@RequestBody String payload) {
        logger.info("获取主任务列表， 请求参数：{}", payload);
        CopInfoDTO listTaskQueryParam = FastJsonUtil.toBean(payload, CopInfoDTO.class);
        PageContentDTO taskList = copStaffInfoService.listCopStaffInfo(listTaskQueryParam);
        return ResultBuilder.buildSuccess(taskList);
    }

    @RequestMapping(value = "/listcop.html", method = RequestMethod.GET)
    public String listCopStaffPage() {
        return "pages/task/maintask/list";
    }

    @ResponseBody
    @RequestMapping(value = "/deletecopstaff", method = RequestMethod.POST)
    public String deleteCopStaff(@RequestBody String payload){
        logger.info("删除主任务，请求参数：{}", payload);
        String taskId = JSON.parseObject(payload).getString("cop_id");
        Integer resultColumn = copStaffInfoService.deleteCopStaffInfo(taskId);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("删除成功");
        } else {
            return ResultBuilder.buildError("删除失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updatecopstaff", method = RequestMethod.POST)
    public String updateCopStaff(@RequestBody String payload){
        logger.info("更新入参；{}", payload);
        CopInfoPO taskInfo = FastJsonUtil.toBean(payload, CopInfoPO.class);
        Integer resultColumn = copStaffInfoService.updateCopStaffInfo(taskInfo);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("更新成功");
        } else {
            return ResultBuilder.buildError("更新失败");
        }
    }

    @RequestMapping(value = "createmaintask.html", method = RequestMethod.GET)
    public String createBundle(Model model) {
        return "pages/task/maintask/create";
    }


    @RequestMapping(value = "/edit/{task_id}.html", method = RequestMethod.GET)
    public String getMainTask(@PathVariable("task_id") String taskId, Model model){
        logger.info("获取taskId={}的详情", taskId);
        CopInfoPO taskInfoPO = copStaffInfoService.getCopStaffInfo(taskId);
        model.addAttribute("copstaff",taskInfoPO);
        return "pages/task/maintask/edit";
    }

}
}
