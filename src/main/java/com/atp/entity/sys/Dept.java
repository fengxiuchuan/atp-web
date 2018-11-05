package com.atp.entity.sys;

import com.atp.dto.base.request.BasePageRequest;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description: Deptentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-11-04 19:54:54
 */
public class Dept extends BasePageRequest implements Serializable {

    /**
     * 主键 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * code 
     */
    private String code;
    /**
     * parentCode 
     */
    private String parentCode;
    /**
     * 类型（1:省、自治区、直辖市；2城市（区）3城镇） 
     */
    private Short type;
    /**
     * deptAllPath 
     */
    private String deptAllPath;
    /**
     * name 
     */
    private String name;
    /**
     * level 
     */
    private Integer level;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentCode() {
        return this.parentCode;
    }
    public void setType(Short type) {
        this.type = type;
    }

    public Short getType() {
        return this.type;
    }
    public void setDeptAllPath(String deptAllPath) {
        this.deptAllPath = deptAllPath;
    }

    public String getDeptAllPath() {
        return this.deptAllPath;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return this.level;
    }
}

