package com.police.controller.copstaffmanagement;

@Controller
@RequestMapping("copstaffmanagement")
public class CopStaffInfoController {
    private static final Logger logger = LoggerFactory.getLogger(CopStaffInfoController.class);
    @Autowired
    private CopStaffInfoService copStaffInfoService;
    @ResponseBody
    @RequestMapping(value = "/createmaintask", method = RequestMethod.POST)
    public String createMainTaskInfo(@RequestBody String payload) {
        logger.info("获取主任务列表， 请求参数：{}", payload);
        TaskInfoPO taskInfo = FastJsonUtil.toBean(payload, TaskInfoPO.class);
        Integer resultColumn = mainTaskInfoService.createMainTaskInfo(taskInfo);
        if (resultColumn != null) {
            return ResultBuilder.buildSuccess("创建主任务成功");
        } else {
            return ResultBuilder.buildError("创建主任务失败");
        }
    }

}
