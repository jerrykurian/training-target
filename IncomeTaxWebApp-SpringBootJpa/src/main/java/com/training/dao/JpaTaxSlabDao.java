package com.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.model.TaxSlab;

@Component
public class JpaTaxSlabDao implements TaxSlabDao {

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<TaxSlab> findSlabs() {
		// TODO Auto-generated method stub
		return (List<TaxSlab>)
				entityManager.createQuery("from tax_slab").getResultList();
	}

}
