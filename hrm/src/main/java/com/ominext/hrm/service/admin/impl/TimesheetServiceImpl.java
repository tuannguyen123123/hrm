/**
* Copyright (c) Acroquest Technology Co., Ltd. All Rights Reserved.
* Please read the associated COPYRIGHTS file for more details.
*
* THE SOFTWARE IS PROVIDED BY Acroquest Technology Co., Ltd.,
* WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
* BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
* IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDER BE LIABLE FOR ANY
* CLAIM, DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
* OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/

package com.ominext.hrm.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ominext.hrm.dto.admin.TimesheetsDto;
import com.ominext.hrm.entity.Timesheets;
import com.ominext.hrm.repository.BaseRepository;
import com.ominext.hrm.repository.admin.TimesheetRepository;
import com.ominext.hrm.service.admin.TimesheetService;
import com.ominext.hrm.service.impl.BaseServiceImpl;
import com.ominext.hrm.util.common.BeanUtil;

@Service("timesheetService")
public class TimesheetServiceImpl extends BaseServiceImpl<Timesheets, TimesheetsDto> implements TimesheetService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Override
	public BaseRepository<Timesheets, Long> getRepository() {
		return timesheetRepository;
	}

	@Override
	public TimesheetsDto createBaseDto(Timesheets entity, Long size) {
		TimesheetsDto simpleDto = new TimesheetsDto();
		BeanUtil.copyPropertiesNative(entity, simpleDto);
		simpleDto.setCount(size);
		return simpleDto;
	}

	@Override
	public Timesheets createEntity(TimesheetsDto timesheetsDto) {
		Timesheets entity = new Timesheets();
		BeanUtil.copyPropertiesNative(timesheetsDto, entity);
		return entity;
	}

	@Override
	public void updateEntity(Timesheets entity, TimesheetsDto timesheetsDto) throws RuntimeException {
		timesheetsDto.setId(entity.getId());
		BeanUtil.copyPropertiesNative(timesheetsDto, entity);
	}
}
