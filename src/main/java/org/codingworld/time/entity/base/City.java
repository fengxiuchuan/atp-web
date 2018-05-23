package org.codingworld.time.entity.base;

import org.codingworld.time.dto.base.request.BasePageRequest;

import java.io.Serializable;

/**
 * @Description: Cityentity 值对象
 * @author: fengxiuchuan
 * @date: 2018-03-02 11:37:51
 */
public class City extends BasePageRequest implements Serializable {

    /**
     * 城市编号 
     */
    private Long id;
    /**
     * 省份编号 
     */
    private Integer provinceId;
    /**
     * 城市名称 
     */
    private String cityName;
    /**
     * 描述 
     */
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getProvinceId() {
        return this.provinceId;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return this.cityName;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}

