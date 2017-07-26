/*******************************************************************************
 * •Copyright 2017 Panasonic Healthcare Co., Ltd. All rights reserved.
 ******************************************************************************/
package com.ominext.hrm.converter.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

import com.ominext.hrm.constant.common.Constant;

/**
 * Conversion to String type
 */
public final class CustomStringConverter implements Converter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_FORMAT_DD_MM_YYYY);
			return sdf.format(value);
		} else {
			return value.toString();
		}
	}
}
