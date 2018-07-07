package com.atp.entity.common;

import java.io.Serializable;

/**
 * @Description: LmsCommonSerialNoentity 值对象
 * @author: rapid-generator
 * @date: 2017-11-01 18:33:34
 */
public class LmsCommonSerialNo implements Serializable {

	private static final long serialVersionUID = -4275591598256165123L;
	/**
     * 序列号名称 
     */
    private String serialId;
    /**
     * 序列号关键字 
     */
    private String serialKey;
    /**
     * 序列号值 
     */
    private Long serialValue;

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getSerialId() {
        return this.serialId;
    }
    public void setSerialKey(String serialKey) {
        this.serialKey = serialKey;
    }

    public String getSerialKey() {
        return this.serialKey;
    }
    public void setSerialValue(Long serialValue) {
        this.serialValue = serialValue;
    }

    public Long getSerialValue() {
        return this.serialValue;
    }
}

