package com.training.dao;

import java.util.List;

import com.training.model.TaxSlab;

public interface TaxSlabDao {
	List<TaxSlab> findSlabs();
}
