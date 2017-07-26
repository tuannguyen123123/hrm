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

package com.ominext.hrm.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ominext.hrm.controller.base.BaseController;
import com.ominext.hrm.dto.admin.TimesheetsDto;
import com.ominext.hrm.service.BaseService;
import com.ominext.hrm.service.admin.TimesheetService;

/**
 * @author Quyettv
 *
 */

@RestController
@RequestMapping("timesheet")
public class TimesheetRestApiController extends BaseController<TimesheetsDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TimesheetService timesheetService;

	@Override
	protected BaseService<TimesheetsDto> getService() {
		// TODO Auto-generated method stub
		return timesheetService;
	}

	// Danh sách time sheet theo user
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String getListTimesheet(@RequestBody @Valid TimesheetsDto timesheetsDto, HttpServletRequest request,
			BindingResult result) {
		// String listTimeSheets = timesheetService.findAll()(timesheetsDto);
		return null;
	}
}
