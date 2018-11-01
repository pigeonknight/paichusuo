package com.police.pojo.entity.copstaff;

import com.alibaba.fastjson.annotation.JSONField;
import com.police.common.util.FastJsonUtil;
import com.police.pojo.entity.BasePO;

import java.util.Date;

public class CopInfoPO extends BasePO {

    @JSONField(name = "copId")
    long copId;

    @JSONField(name = "password")
    String password;

    @JSONField(name = "copName")
    String copName;

    @JSONField(name = "copSex")
    String copSex;

    @JSONField(name = "birthday")
    Date birthday;

    @JSONField(name = "flag")
    int flag;

    @JSONField(name = "manageArea")
    String manageArea;

    public long getCopId() {
        return copId;
    }

    public void setCopId(long copId) {
        this.copId = copId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCopName() {
        return copName;
    }

    public void setCopName(String copName) {
        this.copName = copName;
    }

    public String getCopSex() {
        return copSex;
    }

    public void setCopSex(String copSex) {
        this.copSex = copSex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getManageArea() {
        return manageArea;
    }

    public void setManageArea(String manageArea) {
        this.manageArea = manageArea;
    }

    @Override
    public String toString() {
        return FastJsonUtil.toJSONString(this);
    }
}
