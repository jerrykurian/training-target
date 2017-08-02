package com.training.dao;

import java.util.ArrayList;
import java.util.List;


import com.training.model.TaxSlab;

public class JdbcTaxSlabDao implements TaxSlabDao {

	@Override
	public List<TaxSlab> findSlabs() {
		// TODO Auto-generated method stub
		TaxSlab slab1 = new TaxSlab();
		slab1.setGender("F");
		slab1.setId(1L);
		slab1.setLowerAge(21);
		slab1.setUpperAge(58);
		List<TaxSlab> slabs = new ArrayList<TaxSlab>();
		slabs.add(slab1);
		return slabs;
	}

}
