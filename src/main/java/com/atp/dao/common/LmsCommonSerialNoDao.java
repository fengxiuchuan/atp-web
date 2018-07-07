package com.atp.dao.common;

import com.atp.entity.common.LmsCommonSerialNo;
import com.atp.exception.ATPException;
import com.atp.util.MyMapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: LmsCommonSerialNoDao
 * @author: rapid-generator
 * @date: 2017-11-01 18:33:34
 */
@Repository
public interface LmsCommonSerialNoDao extends MyMapper<LmsCommonSerialNo> {
	
	public Long genSerialNoWithKey(LmsCommonSerialNo para) throws ATPException;
	
}
