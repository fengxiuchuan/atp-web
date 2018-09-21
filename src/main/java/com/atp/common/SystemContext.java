package com.atp.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.Serializable;

/**
 * @ClassName SystemContext
 * @author Feng XiuChuan
 * @Date 2018年6月25日
 * @version 1.0.0
 */
public class SystemContext implements Serializable {

	private static final long serialVersionUID = -8138055031486313133L;

	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();
	private static String realPath;

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) requestLocal.get();
	}

	public static void setRequest(HttpServletRequest request) {
		requestLocal.set(request);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) responseLocal.get();
	}

	public static void setResponse(HttpServletResponse response) {
		responseLocal.set(response);
	}

	public static HttpSession getSession() {
		return (HttpSession) ((HttpServletRequest) requestLocal.get()).getSession();
	}
	
	public static void setRealPath(String realPath) {
		if (SystemContext.realPath == null) {
			synchronized(SystemContext.class) {
				if (SystemContext.realPath == null) {
					SystemContext.realPath = realPath;
				}
			}
		}
	}
	
	public static String getRealPath() {
		synchronized(SystemContext.class) {
			return realPath;
		}
	}
	
	public static String getRealPath(String path) {
		String realPath = getRealPath();
		if (realPath != null) {
			return new File(realPath).getAbsolutePath();
		}
		return path;
	}

}
