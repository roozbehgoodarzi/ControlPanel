package com.ocs.entity;

import com.ocs.util.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Goodarzi on 06/14/2015.
 */
@Entity
@Table(name = "branch_info_table")
public class Branch implements DomainObject {
    @Id
    @Column(name = "CODE", nullable = false)
    Long code;
    String name;
    String userName;
    String ip;
    String path;
    String updateDate ;
    String fName;
    Short automaticFlag;
    Short areaCode;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = DateUtil.getStringDate();
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Short getAutomaticFlag() {
        return automaticFlag;
    }

    public void setAutomaticFlag(Short automaticFlag) {
        this.automaticFlag = automaticFlag;
    }

    public Short getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Short areaCode) {
        this.areaCode = areaCode;
    }
}
