package com.ominext.hrm.repository.admin.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ominext.hrm.entity.Timesheets;
import com.ominext.hrm.repository.admin.TimesheetRepository;
import com.ominext.hrm.repository.impl.BaseRepositoryImpl;

@Repository
public class TimeSheetResipotoryImpl extends BaseRepositoryImpl<Timesheets, Long> implements TimesheetRepository {

	@Override
	public List<Timesheets> deleteById(Long id) {

		StringBuilder sql = new StringBuilder("select reg FROM Timesheets reg ");
		sql.append("where reg.id = :id");

		TypedQuery<Timesheets> query = this.getEntityManager().createQuery(sql.toString(), Timesheets.class);

		query.setParameter("id", id);

		List<Timesheets> timesheets = query.getResultList();

		return timesheets;
	}
	

}
