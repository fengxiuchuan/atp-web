package com.atp.common;

import com.atp.exception.ATPException;
import com.atp.service.impl.common.SerialNoEntry;
import com.atp.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * <h4>序列号生成器</h4><br>
 * 该生成器会根据给定的serialId和serialKey，生成唯一的连续的序列号。<br>
 * 生成的序列号为长整型数据，默认从1开始。<br>
 * 若serialKey发生变化，则序列号将会重新从1开始，可通过改变serialKey的值来达到重置循环的目的。<br>
 * 根据常用的循环模式，这里提供了枚举Cycle，可选择相应的日、月、年循环模式来替代serialKey参数<br>
 * <br>
 * @ClassName SerialNoGenerator
 * @author  fengxiuchuan
 * @Date 2017年11月2日 上午8:53:09
 * @version 1.0.0
 */
public class SerialNoGenerator {
	
	public enum Cycle {
		DAILY("D"), // 日循环
		MONTHLY("M"), // 月循环
		YEARLY("A"); // 年循环
		private String code;
		private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		private static SimpleDateFormat mf = new SimpleDateFormat("yyyyMM");
		private static SimpleDateFormat af = new SimpleDateFormat("yyyy");
		private Cycle(String code) {
			this.code = code;
		}
		public static String getCycleKey(Cycle cycle) {
			Date currDate = new Date();
			if (cycle.code.equals("M")) {
				return mf.format(currDate);
			} else if (cycle.code.equals("A")) {
				return af.format(currDate);
			} else if (cycle.code.equals("D")) {
				return df.format(currDate);
			} else {
				return df.format(currDate); // 默认日循环
			}
		}
	}
	
	private Logger logger = LoggerFactory.getLogger(SerialNoGenerator.class.getClass());
	private static SerialNoGenerator instance;
	
	private SerialNoGenerator() {
	}
	
	public static SerialNoGenerator getGenerator() {
		if (instance == null) {
			synchronized (SerialNoGenerator.class) {
				if (instance == null) {
					instance = new SerialNoGenerator();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 根据给定的ID和Key生成序列号<br>
	 * @param serialId
	 * @param serialKey
	 * @return
	 * @throws ATPException
	 */
	public Long generateSerialNo(String serialId, String serialKey) throws ATPException {
		long startInMillis = System.currentTimeMillis();
		long serialNo = getEntry().generateSerialNo(serialId, serialKey);
		long timeUsed = System.currentTimeMillis() - startInMillis;
		logger.info("[SerialNoGenerator] - [" + serialId + "] - [" + serialKey + "] - A serial number has been generated. [Serial No.: " + serialNo + "] [Time used: " + timeUsed + "ms]");
		return serialNo;
	}
	
	/**
	 * 根据给定的ID和循环周期生成序列号<br>
	 * @param serialId
	 * @param cycle
	 * @return
	 * @throws ATPException
	 */
	public Long generateSerialNo(String serialId, Cycle cycle) throws ATPException {
		return generateSerialNo(serialId, Cycle.getCycleKey(cycle));
	}
	
	private SerialNoEntry getEntry() {
		SerialNoEntry entry = (SerialNoEntry) ServiceContext.getContext().getBean(SerialNoEntry.class);
		return entry;
	}

	public static void main(String[] args) {
		try {
			long serialNo =  SerialNoGenerator.getGenerator().generateSerialNo("riskDataCode" , Cycle.MONTHLY); // 日循环
			String riskDataCode = String.format("%s%s%s", "LR", Cycle.getCycleKey(Cycle.MONTHLY) , StringUtil.padLeft(String.valueOf(serialNo), 6, '0'));
			System.out.println(riskDataCode);
		} catch (ATPException e) {
			e.printStackTrace();

		}
	}
}
