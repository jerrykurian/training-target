package com.itrapp.taxauthority.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itrapp.entities.Gender;
import com.itrapp.entities.Slab;
import com.itrapp.entities.TaxSlab;
import com.itrapp.taxauthority.TaxDetailsManager;

public class TaxDetailsManagerImpl implements TaxDetailsManager {
	private List<TaxSlab> taxSlabs = new ArrayList<TaxSlab>();
	@Override
	public TaxSlab addTaxSlab(int lowerAge, int upperAge, Gender gender,
			List<Slab> slabs) {
		// TODO Auto-generated method stub
		TaxSlab taxSlab = new TaxSlab();
		taxSlab.setGender(gender);
		taxSlab.setLowerAge(lowerAge);
		taxSlab.setUpperAge(upperAge);
		taxSlab.setSlabs(slabs);
		this.taxSlabs.add(taxSlab);
		return taxSlab;
	}
	@Override
	public TaxSlab findTaxSlabFor(int age, Gender gender) {
		// TODO Auto-generated method stub
		Iterator<TaxSlab> slabIterator = taxSlabs.iterator();
		while(slabIterator.hasNext()){
			TaxSlab slab = slabIterator.next();
			if(slab.getLowerAge()<=age && slab.getUpperAge()>=age){
				return slab;
			}
		}
		return null;
	}

}
