package com.atp.service.impl.common;

import com.atp.dao.common.LmsCommonSerialNoDao;
import com.atp.entity.common.LmsCommonSerialNo;
import com.atp.exception.ATPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName SerialNoEntry
 * @author  Yang Yun Long
 * @Date 2017年11月2日 上午8:53:09
 * @version 1.0.0
 */
@Service
public class SerialNoEntry {
	
	@Autowired
	private LmsCommonSerialNoDao serialNoDao;
	
	@Transactional(propagation = Propagation.REQUIRED , readOnly = false)
	public Long generateSerialNo(String serialId, String serialKey) throws ATPException {
		LmsCommonSerialNo dto = new LmsCommonSerialNo();
		dto.setSerialId(serialId);
		dto.setSerialKey(serialKey);
		this.serialNoDao.genSerialNoWithKey(dto);
		long serialNo = dto.getSerialValue();
		return serialNo;
	}
	
}