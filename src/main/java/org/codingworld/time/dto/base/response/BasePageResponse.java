package org.codingworld.time.dto.base.response;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 支持数据分页和封装多个数据记录集合 （父类包含响应的返回代码）
 * 
 */
public class BasePageResponse<T> implements Serializable{

	private static final long serialVersionUID = 6126359897456686831L;

	/**
	 * 已读数量
	 */
	private Integer readCount;
	/**
	 * 未读数量
	 */
	private Integer unreadCount;

	// 默认返回成功
	private boolean success = true;
	
	// 返回单个对象
	private T data;
	
	// 记录总条数
	private Integer totalrows;
	
	//返回页数
	private Integer page;
	
	// 返回数据记录（T可以是Map或DTO对象）
	private List<T> rows;

	public Integer getTotal() {
		return totalrows;
	}

	public void setTotal(Integer total) {
		this.totalrows = total;
	}

	public List<T> getRows() {
		return rows;
	}
	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(List<T> rows) {
	    if (rows instanceof Page) { // 避免客户端要依赖pageHelper插件
	        List<T> rawList = new ArrayList<T>();
	        rawList.addAll(rows);
	        this.rows = rawList;
	    } else {
	        this.rows = rows;
	    }
	}
	
	/**
	 * 计算总页数
	 * @param pageSize
	 * @return
	 */
	public void setTotalPage(Integer pageSize) {
		if (null != pageSize && pageSize.intValue() != 0) {
			Integer totalPage = totalrows / pageSize;
			Integer temp = totalrows % pageSize;
			totalPage = (temp == 0l ? totalPage : totalPage + 1);
			this.page = totalPage;
		}
	}


	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getUnreadCount() {
		return unreadCount;
	}

	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}
}
