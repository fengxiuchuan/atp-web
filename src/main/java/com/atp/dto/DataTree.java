package com.atp.dto;

import java.util.List;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/8/7 16 06
 */
public interface DataTree<T> {
    public Long getId();

    public Long getParentId();

    public void setChildList(List<T> childList);

    public List<T> getChildList();
}
