package com.itrapp.taxauthority;

import java.util.List;

import com.itrapp.entities.Gender;
import com.itrapp.entities.Slab;
import com.itrapp.entities.TaxSlab;

public interface TaxDetailsManager {
	TaxSlab addTaxSlab(int lowerAge, int upperAge, 
			Gender gender, List<Slab> slabs);
	TaxSlab findTaxSlabFor(int age, Gender gender);
}
