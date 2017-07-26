package com.ominext.hrm.repository.admin;

import java.util.List;

import com.ominext.hrm.entity.Timesheets;
import com.ominext.hrm.repository.BaseRepository;

public interface TimesheetRepository extends BaseRepository<Timesheets, Long> {

	List<Timesheets> deleteById(Long id);
}
