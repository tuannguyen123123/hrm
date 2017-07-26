package com.ominext.hrm.converter.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

import com.ominext.hrm.constant.common.Constant;

/**
 * Conversion to Date type
 */
public final class CustomDateConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof String) {
			if (StringUtils.isNotBlank(value.toString())) {
				SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_FORMAT_DD_MM_YYYY);
				try {
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					e.printStackTrace();
					return value.toString();
				}
			} else {
				return null;
			}
		} else {
			return value;
		}
	}

}
