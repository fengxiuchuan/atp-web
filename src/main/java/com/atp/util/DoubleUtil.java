package com.atp.util;


import java.math.BigDecimal;

/**
 * Double类型运算帮助类
 * @author zdx
 *
 */
public class DoubleUtil {
	
	private static final int DEF_DIV_SCALE = 10; 
	
	/** 
	* * 两个Double数相加 * 
	*  
	* @param v1 * 
	* @param v2 * 
	* @return Double 
	*/  
	public static Double add(Double v1, Double v2) {  
	   BigDecimal b1 = new BigDecimal(v1.toString());  
	   BigDecimal b2 = new BigDecimal(v2.toString());  
	   return new Double(b1.add(b2).doubleValue());  
	}
	
	/** 
	* * 三个Double数相加 * 
	*  
	* @param v1 * 
	* @param v2 * 
	* @return Double 
	*/  
	public static Double addThree(Double v1, Double v2,Double v3) {  
	   BigDecimal b1 = new BigDecimal(v1.toString());  
	   BigDecimal b2 = new BigDecimal(v2.toString());
	   BigDecimal b3 = new BigDecimal(v3.toString());
	   return new Double(b1.add(b2).add(b3).doubleValue());  
	}
	  
	/** 
	* * 两个Double数相减 * 
	*  
	* @param v1 * 
	* @param v2 * 
	* @return Double 
	*/  
	public static Double sub(Double v1, Double v2) {  
	   BigDecimal b1 = new BigDecimal(v1.toString());  
	   BigDecimal b2 = new BigDecimal(v2.toString());  
	   return new Double(b1.subtract(b2).doubleValue());  
	}  
	  
	/** 
	* * 两个Double数相乘 * 
	*  
	* @param v1 * 
	* @param v2 * 
	* @return Double 
	*/  
	public static Double mul(Double v1, Double v2) {  
	   BigDecimal b1 = new BigDecimal(v1.toString());  
	   BigDecimal b2 = new BigDecimal(v2.toString());  
	   return new Double(b1.multiply(b2).doubleValue());  
	}  
	  
	/** 
	* * 两个Double数相除 * 
	*  
	* @param v1 * 
	* @param v2 * 
	* @return Double 
	*/  
	public static Double div(Double v1, Double v2) {  
	   BigDecimal b1 = new BigDecimal(v1.toString());  
	   BigDecimal b2 = new BigDecimal(v2.toString());  
	   return new Double(b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP)  
	     .doubleValue());  
	}  
	  
	/** 
	* * 两个Double数相除，并保留scale位小数 * 
	*  
	* @param v1 * 
	* @param v2 * 
	* @param scale * 
	* @return Double 
	*/  
	public static Double div(Double v1, Double v2, int scale) {  
	   if (scale < 0) {  
	    throw new IllegalArgumentException(  
	      "The scale must be a positive integer or zero");  
	   }  
	   BigDecimal b1 = new BigDecimal(v1.toString());  
	   BigDecimal b2 = new BigDecimal(v2.toString());  
	   return new Double(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue());  
	}  
	
	/**
	 * double 类型四舍五入，商业运算
	 * @param
	 */
	public static Double roundDouble(Double v1){
		BigDecimal b = new BigDecimal(v1.toString()).setScale(2, BigDecimal.ROUND_HALF_UP);
		return b.doubleValue();
	}

    /**
     * double 类型四舍五入，商业运算
     * @param
     */
    public static Double roundDouble(Double v1,int newScale){
        BigDecimal b = new BigDecimal(v1.toString()).setScale(newScale, BigDecimal.ROUND_HALF_UP);
        return b.doubleValue();
    }
	/**
	 * Double 比较大小
	 * @param val1
	 * @param val2
	 * @return 返回结果 ：1 第一位数大，2第二数大，3 两位数相等，0 比较失败
	 */
	public static int compare(Double v1, Double v2) {
		BigDecimal val1 = new BigDecimal(v1);  
	    BigDecimal val2 = new BigDecimal(v2);
	    int result = 0;  
	    if (val1.compareTo(val2) < 0) {  
	        result = 2;  
	    }  
	    if (val1.compareTo(val2) == 0) {  
	        result = 3;  
	    }  
	    if (val1.compareTo(val2) > 0) {  
	        result = 1;  
	    }  
	    return result;  
	}  
	
	public static void main(String[] args) {  
	    double b = 0.301;
	    double c = 0.356;
	    //System.out.println(compare(a, b));
	    //System.out.println(roundDouble(roundDouble(roundDouble(c))));
	    System.out.println(DoubleUtil.add(9500.0, 100.895));
	}  
}
