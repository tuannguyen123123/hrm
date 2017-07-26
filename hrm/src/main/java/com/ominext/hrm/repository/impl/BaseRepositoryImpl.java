package com.ominext.hrm.repository.impl;

import java.io.Serializable;

import com.ominext.hrm.repository.BaseRepository;
import com.ominext.hrm.repository.BaseJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends BaseJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

}