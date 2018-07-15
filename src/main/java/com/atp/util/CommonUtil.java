package com.atp.util;

import com.atp.common.GlobalConstants;
import com.atp.common.SerialNoGenerator;
import com.atp.exception.ATPException;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/14 15 19
 */
public class CommonUtil {

    public static String  createOrderNo(String serialId, SerialNoGenerator.Cycle cycle, String prefix, int length) throws ATPException{
        long seriaNo =   SerialNoGenerator.getGenerator().generateSerialNo(serialId ,cycle); // 日循环
        return String.format("%s%s%s", prefix, SerialNoGenerator.Cycle.getCycleKey(cycle) , StringUtil.padLeft(String.valueOf(seriaNo), length, '0'));
    }
}
