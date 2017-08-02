package com.training.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dao.TaxSlabDao;
import com.training.model.TaxSlab;

@RestController
public class TaxSlabResource {
	
	@Autowired
	private TaxSlabDao taxSlabDao;
	
	// GET /slab
	@RequestMapping("/slab")
	public List<TaxSlab> slabs(){
		return this.taxSlabDao.findSlabs();
	}
}
