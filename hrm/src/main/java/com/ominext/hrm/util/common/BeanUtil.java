package com.ominext.hrm.util.common;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;

import com.ominext.hrm.converter.common.CustomDateConverter;
import com.ominext.hrm.converter.common.CustomStringConverter;

public class BeanUtil {

	private static BeanUtilsBean buNative;

	static {
		buNative = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
		buNative.getConvertUtils().register(new CustomDateConverter(), Date.class);
		buNative.getConvertUtils().register(new CustomStringConverter(), String.class);
		buNative.getConvertUtils().register(new LongConverter(null), Long.class);
		buNative.getConvertUtils().register(new IntegerConverter(null), Integer.class);
		buNative.getConvertUtils().register(new ShortConverter(null), Short.class);
		buNative.getConvertUtils().register(new FloatConverter(null), Float.class);
		buNative.getConvertUtils().register(new DoubleConverter(null), Double.class);
	}

	private BeanUtil() {

	}

	public static void copyPropertiesNative(Object source, Object target) {
		try {
			buNative.copyProperties(target, source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object createAndCopyPropertiesNative(Object source, Class c) {
		Object target = null;
		try {
			target = c.newInstance();
			buNative.copyProperties(target, source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

}
