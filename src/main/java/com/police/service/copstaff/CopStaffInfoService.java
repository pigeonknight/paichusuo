package com.police.service.copstaff;

import com.police.pojo.dto.copstaff.CopInfoDTO;
import com.police.pojo.entity.copstaff.CopInfoPO;
import com.police.pojo.dto.PageContentDTO;
public interface CopStaffInfoService {
    Integer createCopStaffInfo(CopInfoPO copInfoPO);

    Integer deleteCopStaffInfo(String taskId);

    Integer updateCopStaffInfo(CopInfoPO copInfoPO);

    CopInfoPO getCopStaffInfo(CopInfoPO copInfoPO);

    PageContentDTO listCopStaffInfo(CopInfoDTO copInfoDTO);

    Integer countCopStaff(CopInfoDTO copInfoDTO);
}
